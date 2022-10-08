package com.example.todothymeleaf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    public long id;

    public String title;

    public boolean isCompleted;

    public Todo(String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Todo() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
