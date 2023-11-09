package com.learning.TODO.dao;

import com.learning.TODO.helper.Helper;
import com.learning.TODO.entities.TodoEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoMapper implements RowMapper<TodoEntity> {
    @Override
    public TodoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        TodoEntity todo = new TodoEntity();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setTodoDate(Helper.parseDate(rs.getObject("todoDate")));
        todo.setCreatedDate(Helper.parseDate(rs.getObject("createdDate")));
        return todo;
    }
}
