package com.farukkaradeniz.rulechaining;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = ResponseStatusException.class)
    protected ResponseEntity<PersonOutput> handleException(ResponseStatusException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new PersonOutput("FAILURE", ex.getReason()));
    }
}
