package com.learning.TODO.services.impl;

import com.learning.TODO.entities.TodoEntity;
import com.learning.TODO.exceptions.TodoNotFoundException;
import com.learning.TODO.repositories.TodoRepository;
import com.learning.TODO.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoServiceJPAImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public TodoEntity createTodo(TodoEntity todo) {
        return todoRepository.saveAndFlush(todo);
    }

    @Override
    public List<TodoEntity> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public TodoEntity getTodo(Integer id) throws  TodoNotFoundException{
        Optional<TodoEntity> todoEntityOptional = todoRepository.findById(id);
        return todoEntityOptional.orElseThrow(()->new TodoNotFoundException("Todo with id:"+id+"not found", HttpStatus.BAD_REQUEST));
    }

    @Override
    public TodoEntity updateTodo(Integer id, TodoEntity todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }

    @Override
    public boolean deleteTodo(Integer id) {
        todoRepository.deleteById(id);
        return true;
    }
}
