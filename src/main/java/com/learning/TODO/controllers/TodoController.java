package com.learning.TODO.controllers;

import com.learning.TODO.entities.TodoEntity;
import com.learning.TODO.exceptions.TodoNotFoundException;
import com.learning.TODO.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired(required = false)
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoEntity> createTodo(@RequestBody TodoEntity todo){
        TodoEntity resultantTodo = todoService.createTodo(todo);
//        String s = null;
//        s.length();
        return new ResponseEntity<>(resultantTodo, HttpStatus.CREATED);
    }

    //Get all todos
    @GetMapping
    public ResponseEntity<List<TodoEntity>> getAllTodos(){
        List<TodoEntity> allTodos = todoService.getAllTodos();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    //Get a single todo
    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTodo(@PathVariable Integer id){
        try{
            TodoEntity todo = todoService.getTodo(id);
            return new ResponseEntity<>(todo,HttpStatus.OK);
        }
        catch(TodoNotFoundException e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Map<String,Object> updateTodo(@PathVariable Integer id, @RequestBody TodoEntity todo){
        TodoEntity updatedTodo = todoService.updateTodo(id,todo);
        Map<String,Object>  response = new HashMap<>();
        response.put("isSuccessful",true);
        response.put("data",todo);
        return response;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTodo(@PathVariable Integer id){
        boolean isDeleted = todoService.deleteTodo(id);
        return isDeleted;
    }

    //Exception handler
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatPointerException(NumberFormatException ex){
        return new ResponseEntity<>("File level:Number-format exception: "+ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

}