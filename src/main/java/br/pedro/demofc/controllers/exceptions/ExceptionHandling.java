package br.pedro.demofc.controllers.exceptions;

import br.pedro.demofc.services.ServiceViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ServiceViolationException.class)
    public ResponseEntity<StandardError> serviceViolationException(HttpServletRequest request, ServiceViolationException e){
        String htmlCod = e.getMessage().substring(1,4);

        StandardError error = new StandardError();
        error.setDate(LocalDate.now());
        error.setStatus(Integer.parseInt(htmlCod));
        error.setError("Service violation exception");
        error.setMessage(e.getMessage().substring(6));
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<StandardError> dataParserException(HttpServletRequest request, DateTimeParseException e){
        StandardError error = new StandardError();
        error.setDate(LocalDate.now());
        error.setStatus(400);
        error.setError("Invalid data format argument");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationException(HttpServletRequest request, MethodArgumentNotValidException e){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        StandardError error = new StandardError(){

            private final List<FieldMessage> errors = new ArrayList<>();

            public List<FieldMessage> getErrors() {
                return errors;
            }

            @Override
            public void addError(String fieldName, String message){
                errors.add(new FieldMessage(fieldName, message));
            }
        };

        error.setDate(LocalDate.now());
        error.setStatus(status.value());
        error.setPath(request.getRequestURI());

        e.getBindingResult().getFieldErrors().forEach(err -> error.addError(err.getField(),err.getDefaultMessage()));

        return ResponseEntity.status(status).body(error);
    }
}
