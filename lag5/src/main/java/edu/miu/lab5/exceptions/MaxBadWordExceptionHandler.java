package edu.miu.lab5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MaxBadWordExceptionHandler {
    @ExceptionHandler(value = MaxBadWordExceptions.class)
    public ResponseEntity<Object> exception(MaxBadWordExceptions exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
