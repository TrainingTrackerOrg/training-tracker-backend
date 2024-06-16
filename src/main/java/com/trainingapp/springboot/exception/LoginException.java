package com.trainingapp.springboot.exception;

public class LoginException extends RuntimeException{
    public LoginException() {
        super("Credentials are invalid");
    }
}
