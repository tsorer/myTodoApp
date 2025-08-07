package com.javatrainingschool.model;
import java.util.ArrayList;

public class TodoList {

    private ArrayList<TodoEntry> todoList = new ArrayList<>();

    /**
     * Fügt einen neuen TodoEntry der Liste hinzu.
     * @param id die ID des Todo-Eintrags
     * @param todoName der Name des Todo-Eintrags
     */
    public void addTodoEntry(int id, String todoName){
        TodoEntry todoEntry = new TodoEntry(id, todoName);
        this.todoList.add(todoEntry);
    }

    /**
     * Gibt die TodoListe aus.
     * @return die Liste der Todo-Einträge
     */
    public ArrayList<TodoEntry> showTodoList(){
        return this.todoList; // Rückgabe der Liste
    }
}
