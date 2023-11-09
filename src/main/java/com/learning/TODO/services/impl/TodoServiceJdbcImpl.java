package com.learning.TODO.services.impl;

import com.learning.TODO.dao.TodoDAO;
import com.learning.TODO.entities.TodoEntity;
import com.learning.TODO.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TodoServiceJdbcImpl implements TodoService {
    @Autowired(required = false)
    TodoDAO todoDAO;

    Logger logger = LoggerFactory.getLogger(TodoServiceJdbcImpl.class);
    List<TodoEntity> todos = new ArrayList<>();//To be used as alternative for the database
    //Create todo
    public TodoEntity createTodo(TodoEntity todo){
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

    public List<TodoEntity> getAllTodos(){
        List<TodoEntity> todos = todoDAO.getAllTodos();
        return todos;
    }

    public TodoEntity getTodo(Integer id) {
//        Todo resultantTodo = todos.stream()
//                .filter(todo->todo.getId() == id)
//                .findAny()
//                .orElseThrow(()->new TodoNotFoundException("random", HttpStatus.MULTI_STATUS));
        TodoEntity resultantTodo = todoDAO.getTodo(123);
        return resultantTodo;
    }

    public TodoEntity updateTodo(Integer id, TodoEntity todo){
//        List<Todo> updatedTodos = todos.stream()
//                .map(currentTodo->{
//                    if(currentTodo.getId() == id) {
//                        currentTodo.setContent(todo.getTitle());
//                        currentTodo.setStatus(todo.getStatus());
//                        currentTodo.setTitle(todo.getTitle());
//                    }
//                    return currentTodo;
//                })
//                .collect(Collectors.toList());
//        todos = updatedTodos;
        TodoEntity updatedTodo = todoDAO.updateTodo(id,todo);
        return updatedTodo;
    }

    public boolean deleteTodo(Integer id){
//        List<Todo> updatedTodos = todos.stream()
//                .filter(todo -> todo.getId() != id)
//                .collect(Collectors.toList());
//        todos = updatedTodos;
        boolean isDeleted = todoDAO.deleteTodo(id);
        return isDeleted;
    }

}
