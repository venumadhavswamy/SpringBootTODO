package com.learning.TODO.services;

import com.learning.TODO.entities.TodoEntity;
import com.learning.TODO.exceptions.TodoNotFoundException;

import java.text.ParseException;
import java.util.List;

public interface TodoService {
    public TodoEntity createTodo(TodoEntity todo);
    public List<TodoEntity> getAllTodos();
    public TodoEntity getTodo(Integer id) throws TodoNotFoundException;
    public TodoEntity updateTodo(Integer id, TodoEntity todo);
    public boolean deleteTodo(Integer id);
}
