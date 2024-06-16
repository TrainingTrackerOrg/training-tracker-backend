package com.trainingapp.springboot.exception;

public class NoDataException extends RuntimeException{
    public NoDataException() {
        super("One or more fields are empty!");
    }
}
