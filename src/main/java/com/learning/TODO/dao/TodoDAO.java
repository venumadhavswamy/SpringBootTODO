package com.learning.TODO.dao;

import com.learning.TODO.helper.Helper;
import com.learning.TODO.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Component
public class TodoDAO {
    private JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(TodoDAO.class);

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public TodoDAO(@Autowired JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

        //Create todo-table if not exists
        String createQuery = "create table IF NOT EXISTS todo(id int primary key," +
                "title varchar(50) not null,content varchar(500)," +
                "status varchar(50) not null,createdDate datetime,todoDate datetime)";
        jdbcTemplate.update(createQuery);
        logger.info("Table created");
    }

    public Todo createTodo(Todo todo){
        String insertQuery = "insert into todo(id,title,content,status,createdDate,todoDate) values(?,?,?,?,?,?)";
        int rows=0;
        try {
            rows = jdbcTemplate.update(insertQuery, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(), new Date(System.currentTimeMillis()), todo.getTodoDate());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("No. of rows affected: "+rows);
        return todo;
    }

    //Get single todo
    public Todo getTodo(int id){
        String selectQuery = "select * from todo where id=?";
        Todo todo = jdbcTemplate.queryForObject(selectQuery,new TodoMapper(),id);
//        logger.info("todo {}", todoMap);
//        Todo resultantTodo = new Todo();
//        resultantTodo.setId((Integer)todoMap.get("id"));
//        resultantTodo.setTitle((String)todoMap.get("title"));
//        resultantTodo.setContent((String) todoMap.get("content"));
//        resultantTodo.setTodoDate(Helper.parseDate(todoMap.get("todoDate")));
//        resultantTodo.setCreatedDate(Helper.parseDate(todoMap.get("createdDate")));
        return todo;
    }

    public List<Todo> getAllTodos(){
        String selectQuery = "select * from todo;";
        List<Todo> todosList = jdbcTemplate.query(selectQuery,new TodoMapper());
//        List<Todo> todosList = todosMap.stream()
//                .map((todoMap)->{
//                    Todo resultantTodo = new Todo();
//                    resultantTodo.setId((Integer)todoMap.get("id"));
//                    resultantTodo.setTitle((String)todoMap.get("title"));
//                    resultantTodo.setContent((String) todoMap.get("content"));
//                    resultantTodo.setTodoDate(Helper.parseDate(todoMap.get("todoDate")));
//                    resultantTodo.setCreatedDate(Helper.parseDate(todoMap.get("createdDate")));
//                    return resultantTodo;
//                }).collect(Collectors.toList());
        return todosList;
    }

    public Todo updateTodo(int id, Todo todo){
        String updateQuery = "UPDATE todo set title=?,content=?,status=?,createdDate=?,todoDate=? WHERE id=?";
        int affectedRows = jdbcTemplate.update(updateQuery,todo.getTitle(),todo.getContent(),todo.getStatus(),new Date(),todo.getTodoDate(),id);
        todo.setId(id);
        todo.setCreatedDate(new Date());
        return affectedRows>0?todo:null;
    }

    public boolean deleteTodo(int id){
        String deleteQuery = "DELETE FROM todo where id=?";
        int affectedRows = jdbcTemplate.update(deleteQuery,id);
        return  affectedRows>0?true:false;
    }
}
