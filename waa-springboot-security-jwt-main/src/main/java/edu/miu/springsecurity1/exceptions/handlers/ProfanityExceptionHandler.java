package edu.miu.springsecurity1.exceptions.handlers;

import edu.miu.springsecurity1.exceptions.MaxProfanityWordsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfanityExceptionHandler {

    @ExceptionHandler(value = MaxProfanityWordsException.class)
    public ResponseEntity<Object> exception(MaxProfanityWordsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
