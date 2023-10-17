package com.learning.TODO.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String content;
    private String status;
    private Date createdDate;

    @JsonFormat(pattern="dd/mm/yyyy")
    private Date todoDate;

    public Todo(int id, String title, String content, String status, Date createdDate, Date todoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createdDate = createdDate;
        this.todoDate = todoDate;
    }
    public Todo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", todoDate=" + todoDate +
                '}';
    }
}
