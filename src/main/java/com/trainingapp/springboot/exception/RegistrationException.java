package com.trainingapp.springboot.exception;

public class RegistrationException extends RuntimeException{
    public RegistrationException(String username) {
        super("Username '" + username + "' is already taken.");
    }
}
