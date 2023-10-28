package com.learning.TODO.exceptions;

import org.springframework.http.HttpStatus;

public class TodoNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public TodoNotFoundException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
