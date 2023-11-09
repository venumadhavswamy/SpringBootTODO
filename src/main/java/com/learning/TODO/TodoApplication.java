package com.learning.TODO;

import com.learning.TODO.entities.TodoEntity;
import com.learning.TODO.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	@Autowired(required = false)
	private TodoService todoService;
	Logger logger = LoggerFactory.getLogger(TodoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	//This method is always called on the execution of SpringApplication.run()
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Commandlinerunner Run method called");

		TodoEntity todo1 = new TodoEntity();
		todo1.setId(new Random().nextInt(1000));
		todo1.setTitle("Shopping");
		todo1.setStatus("pending");
		todo1.setContent("Gym food");
		todo1.setCreatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		todo1.setTodoDate(new Date());

		todoService.createTodo(todo1);
	}
}
