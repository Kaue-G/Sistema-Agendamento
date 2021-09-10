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

    private List<Disponibility> findUnavailable(BookingDTO dto, Integer id){

        List<Disponibility> disponibilities;

        if(dto.getType() != Type.DAY)
            disponibilities = repository.findByEndAndBegin(dto.getMoment(),dto.getBegin(),dto.getEnd(),id);
         else
            disponibilities = repository.findByEndAndBegin(dto.getMoment(),constraints.getBEGIN(),constraints.getEND(),id);

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
            errors.add(new FieldMessage("employee_id","This can not be null"));
        } else {
            Optional<Employee> e = eRepository.findById(dto.getEmployee_id());
            if(e.isEmpty()){
                errors.add(new FieldMessage("employee_id","This user does not exist"));
            } else {
                Booking b = bRepository.findByEmployeeAndMoment(e.get(),dto.getMoment());
                if(b != null){
                    errors.add(new FieldMessage("moment","You already made a reservation on: " + dto.getMoment() + ", USER: " + dto.getEmployee_id()));
                }
            }
        }

        if(dto.getType() == Type.DAY){
            dto.setWeight(1);
        } else {
            dto.setWeight(2);
        }

        List<Disponibility> disponibilities = findUnavailable(dto,id);
        List<Disponibility> notAvailable = disponibilities.stream().filter(disp -> !disp.preTryAvailable(dto.getWeight(),constraints.getPERCENTAGE())).collect(Collectors.toList());


        if(!notAvailable.isEmpty()){
            errors.add(new FieldMessage("begin","There is to many people between " +
                    notAvailable.get(0).getId().getBeginHour() + " hours and " +
                    notAvailable.get(notAvailable.size()-1).getId().getBeginHour() + " hours"));
        }

        if(dto.getType() != Type.DAY){ // Caso seja REUNION
            if(dto.getBegin() < constraints.getBEGIN()){
                errors.add(new FieldMessage("begin","Begin must be greater than " + constraints.getBEGIN()));
            }
            if(dto.getEnd() <= dto.getBegin()){
                errors.add(new FieldMessage("end","End time must be greater than begin time"));
            }

            Room c =  cRepository.findByIdAndOffice(dto.getChair(),id);

            if(c == null){
                errors.add(new FieldMessage("chair", "This chair does not count on database"));
            } else {
                List<DisponibilityRoom> allRooms = drRepository.findAll();

                List<DisponibilityRoom> dRooms = disponibilities.stream().map(disp -> {
                    DisponibilityRoomPK pk = new DisponibilityRoomPK(disp.getId(),c.getId());
                    Optional<DisponibilityRoom> optionalRoom = allRooms.stream().filter(room -> room.getId().equals(pk)).distinct().findAny();
                    return optionalRoom.orElse(null);
                }).filter(Objects::nonNull).collect(Collectors.toList());

                if(!dRooms.isEmpty() && dRooms.stream().anyMatch(room -> room.getCapacity() + dto.getWeight() > c.getCapacity())){
                    errors.add(new FieldMessage("chair", "This chair has already taken for another group of people"));
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
