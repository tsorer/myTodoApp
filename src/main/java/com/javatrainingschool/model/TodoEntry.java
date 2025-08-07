package com.javatrainingschool.model;
public class TodoEntry {
    public int id;
    private String todoName;


    public TodoEntry(int id, String todoName){
        this.id = id;
        this. todoName = todoName;
    }


    //Getters

    public int getId() {
        return id;
    }
    public String getTodoName() {
        return todoName;
    }

    //Setters

    public void setId(int Id){
        this.id = Id;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }


}
