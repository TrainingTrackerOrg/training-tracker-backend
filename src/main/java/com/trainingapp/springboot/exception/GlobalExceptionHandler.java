package com.trainingapp.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus( HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegistrationException.class)
    public String handleUsernameAlreadyTakenException(RegistrationException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(LoginException.class)
    public String handleUsernameAlreadyTakenException(LoginException ex) {
        return ex.getMessage();
    }
}
