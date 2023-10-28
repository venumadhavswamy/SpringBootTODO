package com.learning.TODO.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex){
        logger.info("Null pointer exception has been generated");
        ex.printStackTrace();
        return new ResponseEntity<>("Handled globally: Null pointer exception: "+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleTodoNotFoundException(TodoNotFoundException ex){
        ExceptionResponse response = new ExceptionResponse("Todo not found",false,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
