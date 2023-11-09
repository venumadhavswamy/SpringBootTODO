package com.learning.TODO.repositories;

import com.learning.TODO.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {

}
