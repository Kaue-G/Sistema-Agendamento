package br.pedro.demofc.controllers.exceptions;

import br.pedro.demofc.config.Constraints;
import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.entities.*;
import br.pedro.demofc.entities.pk.DisponibilityRoomPK;
import br.pedro.demofc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BookingInsertValidator implements ConstraintValidator<BookingValid, BookingDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DisponibilityRepository repository;

    @Autowired
    private EmployeeRepository eRepository;

    @Autowired
    private BookingRepository bRepository;

    @Autowired
    private RoomRepository cRepository;

    @Autowired
    private DisponibilityRoomRepository drRepository;

    @Autowired
    private Constraints constraints;

    private LocalDate stringToDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date,formatter);
    }

    private List<Disponibility> findUnavailable(BookingDTO dto, Integer id){

        List<Disponibility> disponibilities;

        if(dto.getType() != Type.DAY)
            disponibilities = repository.findByEndAndBegin(stringToDate(dto.getMoment()),dto.getBegin(),dto.getEnd(),id);
         else
            disponibilities = repository.findByEndAndBegin(stringToDate(dto.getMoment()),constraints.getBEGIN(),constraints.getEND(),id);

        return disponibilities;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(BookingDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> errors = new ArrayList<>();

        @SuppressWarnings("unchecked")
        var uriVars = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        int id = Integer.parseInt(uriVars.get("id"));

        if(dto.getEmployee_id() == null){
            errors.add(new FieldMessage("employee_id","O usuário não pode ser nulo"));
        } else {
            Optional<Employee> e = eRepository.findByEmail(dto.getEmployee_id());
            if(e.isEmpty()){
                errors.add(new FieldMessage("employee_id","Esse email não existe no sistema"));
            } else {
                Booking b = bRepository.findByEmployeeAndMoment(e.get(),stringToDate(dto.getMoment()));
                if(b != null){
                    errors.add(new FieldMessage("moment","Você já fez uma reserva em: " + dto.getMoment() + ", EMAIL: " + dto.getEmployee_id()));
                }
            }
        }

//        if(dto.getType() != Type.DAY && (dto.getBegin() == null || dto.getEnd() == null)){
//            errors.add(new FieldMessage("begin", "Begin or end when in reunion must be informed"));
//        }

        if(dto.getType() == Type.DAY){
            dto.setWeight(1);
        }

        if(dto.getType() != Type.DAY && dto.getWeight() == null ){
            dto.setWeight(1);
        }

        List<Disponibility> disponibilities = findUnavailable(dto,id);
        List<Disponibility> notAvailable = disponibilities.stream().filter(disp -> !disp.preTryAvailable(dto.getWeight(),constraints.getPERCENTAGE())).collect(Collectors.toList());


        if(!notAvailable.isEmpty()){
            errors.add(new FieldMessage("begin","Há uma grande quantidade de pessoas entre " +
                    notAvailable.get(0).getId().getBeginHour() + " horas e " +
                    notAvailable.get(notAvailable.size()-1).getId().getBeginHour() + " horas"));
        }

        if(dto.getType() != Type.DAY){ // Caso seja REUNION
            if(dto.getBegin() < constraints.getBEGIN()){
                errors.add(new FieldMessage("begin","O horário de início deve ser maior que " + constraints.getBEGIN()));
            }
            if(dto.getEnd() <= dto.getBegin()){
                errors.add(new FieldMessage("end","O horário final deve ser maior que o horário inicial"));
            }

            Room c =  cRepository.findByIdAndOffice(dto.getChair(),id);

            if(c == null){
                errors.add(new FieldMessage("chair", "Essa sala não se encontra no sistema"));
            } else {
                List<DisponibilityRoom> allRooms = drRepository.findAll();

                List<DisponibilityRoom> dRooms = disponibilities.stream().map(disp -> {
                    DisponibilityRoomPK pk = new DisponibilityRoomPK(disp.getId(),c.getId());
                    Optional<DisponibilityRoom> optionalRoom = allRooms.stream().filter(room -> room.getId().equals(pk)).distinct().findAny();
                    return optionalRoom.orElse(null);
                }).filter(Objects::nonNull).collect(Collectors.toList());

                if(!dRooms.isEmpty() && dRooms.stream().anyMatch(room -> room.getCapacity() + dto.getWeight() > c.getCapacity())){
                    errors.add(new FieldMessage("chair", "Essa sala já está sendo utilizada por outro grupo de pessoas"));
                }
            }
        }

        for(FieldMessage f : errors){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return errors.isEmpty();
    }
}
