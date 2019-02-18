package com.example.todoapplication;

public class ToDo {
    Object userId;
    Object id;
    Object title;
    Object completed;

    public ToDo(Object userId, Object id, Object title, Object completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Object getUserId() {
        return userId;
    }

    public Object getId() {
        return id;
    }

    public Object getTitle() {
        return title;
    }

    public Object getCompleted() {
        return completed;
    }
}
