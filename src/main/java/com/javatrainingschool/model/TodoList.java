package com.javatrainingschool.model;
import java.util.ArrayList;

public class TodoList {

	private int idCounter = 0;
    private ArrayList<TodoEntry> todoList = new ArrayList<>();

    /**
     * Fügt einen neuen TodoEntry der Liste hinzu.
     * @param id die ID des Todo-Eintrags
     * @param todoName der Name des Todo-Eintrags
     */
    public void addTodoEntry(String todoName){
    	
        TodoEntry todoEntry = new TodoEntry(idCounter++, todoName);
        this.todoList.add(todoEntry);
    }
    
    /**
    * Entfernt einen TodoEntry aus der Liste.
    * @param todoId die ID des Todo-Eintrags
    */
   public void removeTodoEntry(int todoId) {
       todoList.removeIf(todoEntry -> todoEntry.getId() == todoId);
   }

    /**
     * Gibt die TodoListe aus.
     * @return die Liste der Todo-Einträge
     */
    public ArrayList<TodoEntry> showTodoList(){
        return this.todoList; // Rückgabe der Liste
    }
    
    
}
