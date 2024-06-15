package com.trainingapp.springboot.exception;

public class LoginException extends RuntimeException{
    public LoginException(String username) {
        super("Credentials are invalid");
    }
}
