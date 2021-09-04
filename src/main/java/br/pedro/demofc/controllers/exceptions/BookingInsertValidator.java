package br.pedro.demofc.controllers.exceptions;

import br.pedro.demofc.dtos.BookingDTO;
import br.pedro.demofc.dtos.Type;
import br.pedro.demofc.entities.Booking;
import br.pedro.demofc.entities.Disponibility;
import br.pedro.demofc.entities.Employee;
import br.pedro.demofc.repositories.BookingRepository;
import br.pedro.demofc.repositories.DisponibilityRepository;
import br.pedro.demofc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    private List<Disponibility> findUnavailable(BookingDTO dto, Integer id){

        List<Disponibility> notAvailable;
        if(dto.getType() != Type.DAY)
            notAvailable = repository.findByEndAndBegin(dto.getMoment(),dto.getBegin(),dto.getEnd(),id);
         else
            notAvailable = repository.findByEndAndBegin(dto.getMoment(),8,18,id);

        notAvailable = notAvailable.stream().filter(disp -> !disp.isAvailable()).collect(Collectors.toList());

        return notAvailable;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(BookingDTO dto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        var uriVars = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        int id = Integer.parseInt(uriVars.get("id"));

//        for(String var : uriVars.keySet()){
//            System.out.println(var + ":" + uriVars.get(var));
//        }

        List<FieldMessage> errors = new ArrayList<>();

        Optional<Employee> e = eRepository.findById(dto.getEmployee_id());

        if(e.isEmpty()){
            errors.add(new FieldMessage("employee_id","This user does not exist"));
        } else {
            Booking b = bRepository.findByEmployeeAndMoment(e.get(),dto.getMoment());
            if(b != null){
                errors.add(new FieldMessage("moment","You already made a reservation on: " + dto.getMoment() + ", USER: " + dto.getEmployee_id()));
            }
        }

        if(dto.getType() != Type.DAY && dto.getBegin() < 8){
            errors.add(new FieldMessage("begin","Begin must be greater than 8"));
        }

        if(dto.getType() != Type.DAY && dto.getEnd() <= dto.getBegin()){
            errors.add(new FieldMessage("end","End time must be greater than begin time"));
        }

        List<Disponibility> notAvailable = findUnavailable(dto,id);
        if(!notAvailable.isEmpty()){
            errors.add(new FieldMessage("begin","There is to many people between " +
                    notAvailable.get(0).getId().getBeginHour() + " hours and " +
                    notAvailable.get(notAvailable.size()-1).getId().getBeginHour() + " hours"));
        }

        for(FieldMessage f : errors){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName()).addConstraintViolation();
        }

        return errors.isEmpty();
    }
}
