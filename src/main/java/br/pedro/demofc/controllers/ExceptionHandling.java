package br.pedro.demofc.controllers;

import br.pedro.demofc.services.ServiceViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
}
