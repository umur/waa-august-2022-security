package com.waa.security.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> handleGenericNotFoundException(Exception ex) {
        ex.printStackTrace();
        ApiResponse<Object> apiError = new ApiResponse<>();
        Optional<?> cause =
                Optional.ofNullable(ex.getCause());
        if (cause.isPresent()) {
            apiError.setData(cause.toString());
        } else {
            apiError.setData("Unknown");
        }
        apiError.setMessage(ex.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}

