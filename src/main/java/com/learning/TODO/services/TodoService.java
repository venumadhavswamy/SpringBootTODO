package com.learning.TODO.services;

import com.learning.TODO.models.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoService {

    List<Todo> todos = new ArrayList<>();//To be used as alternative for the database
    //Create todo
    public Todo createTodo(Todo todo){
        //Logic on data needs to be performed here
        todos.add(todo);
    }
}
