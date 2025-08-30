package com.javatrainingschool.model;

import java.util.Date;

public class TodoEntry {
    private int id;
    private String title;
    private String category; // Optionale Kategorie
    private Date dueDate; // Optionales Fälligkeitsdatum
    private boolean isImportant; // Markierung als wichtig
    private boolean isCompleted; // Markierung als abgeschlossen


    public TodoEntry(int id, String todoTitle, String todoCategory, Date todoDueDate, boolean todoIsImportant, boolean todoIsCompleted){
        this.id = id;
        this. title = todoTitle;
        this.category = todoCategory;
        this.dueDate= todoDueDate;
        this.isImportant = todoIsImportant;
        this.isCompleted = todoIsCompleted;
        
    }


    //Getters

    public int getId() {
        return id;
    }
    public String getTodoTitle() {
        return title;
    }
    
    public String getTodoCategory() {
        return category;
    }
    
    public Date getTodoDueDate() {
        return dueDate;
    }
    
    public boolean getTodoIsImportant() {
        return isImportant;
    }
    
    public boolean getTodoIsCompleted() {
        return isCompleted;
    }

    //Setters

    public void setId(int id){
        this.id = id;
    }

    public void setTodoTitle(String todoTitle) {
        this.title = todoTitle;
    }
    
    public void setTodoCategory(String todoCategory) {
        this.category = todoCategory;
    }
    
    public void setTodoDueDate(Date todoDueDate) {
        this.dueDate = todoDueDate;
    }
    
    public void isImportant(boolean todoIsImportant) {
        this.isImportant = todoIsImportant;
    }
    
    public void isCompleted(boolean todoIsCompleted) {
        this.isCompleted = todoIsCompleted;
    }

    // Überprüfen, ob das Fälligkeitsdatum überschritten ist
    public boolean isOverdue() {
        return dueDate != null && dueDate.before(new Date());
    }
    
    // toString-Methode
    @Override
    public String toString() {
        return "ID: " + id + ", Todo: " + title;
    }


}
