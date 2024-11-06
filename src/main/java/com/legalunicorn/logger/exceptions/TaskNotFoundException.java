package com.legalunicorn.logger.exceptions;

public class TaskNotFoundException extends RuntimeException{
    private String message;
    public TaskNotFoundException(){}
    public TaskNotFoundException(String msg){
        super(msg);
        this.message = msg;
    }
}
