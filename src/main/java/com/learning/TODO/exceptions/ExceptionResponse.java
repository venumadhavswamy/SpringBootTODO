package com.learning.TODO.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String message;
    private Boolean isSuccess;
    private HttpStatus status;

    public ExceptionResponse(String message, Boolean isSuccess, HttpStatus status) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.status = status;
    }
    public ExceptionResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
