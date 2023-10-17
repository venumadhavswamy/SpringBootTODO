package com.learning.TODO.services;

import com.learning.TODO.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    List<Todo> todos = new ArrayList<>();//To be used as alternative for the database
    //Create todo
    public Todo createTodo(Todo todo){
        //Logic on data needs to be performed here
        Random random = new Random();
        int id = random.nextInt();
        todo.setId(id);
        Date currentDate = new Date();
        todo.setCreatedDate(currentDate);
        todos.add(todo);
        logger.info("todo list: "+todos.toString());
        return todo;
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo getTodo(Integer id) {
        Todo resultantTodo = todos.stream()
                .filter(todo->todo.getId() == id)
                .findAny()
                .orElse(null);
        return resultantTodo;
    }

    public boolean updateTodo(Integer id, Todo todo){
        List<Todo> updatedTodos = todos.stream()
                .map(currentTodo->{
                    if(currentTodo.getId() == id) {
                        currentTodo.setContent(todo.getTitle());
                        currentTodo.setStatus(todo.getStatus());
                        currentTodo.setTitle(todo.getTitle());
                    }
                    return currentTodo;
                })
                .collect(Collectors.toList());
        todos = updatedTodos;
        return true;
    }

    public boolean deleteTodo(Integer id){
        List<Todo> updatedTodos = todos.stream()
                .filter(todo -> todo.getId() != id)
                .collect(Collectors.toList());
        todos = updatedTodos;
        return true;
    }
}
