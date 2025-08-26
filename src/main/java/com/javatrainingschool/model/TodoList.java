package com.javatrainingschool.model;
import java.util.ArrayList;
import java.util.Date;

public class TodoList {

	private int idCounter = 0;
    private ArrayList<TodoEntry> todoList = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>(); // Liste für Kategorien

    public TodoList() {
        // Beispielkategorien hinzufügen
        categories.add("Arbeit");
        categories.add("Persönlich");
        categories.add("Einkauf");
    }

    /**
     * Fügt einen neuen TodoEntry der Liste hinzu.
     * @param id die ID des Todo-Eintrags
     * @param todoTitle der Name des Todo-Eintrags
     */
    public void addTodoEntry(String todoTitle, String todoCategory,Date todoDueDate , boolean todoIsImportant, boolean todoIsCompleted )
    {            
        TodoEntry todoEntry = new TodoEntry(idCounter++, todoTitle, todoCategory,todoDueDate, todoIsImportant, todoIsCompleted);
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
    
    /**
     * Gibt die Liste der verfügbaren Kategorien zurück.
     * @return die Liste der Kategorien
     */
    public ArrayList<String> getCategories() {
        return this.categories; // Rückgabe der Kategorien
    }

    /**
     * Fügt eine neue Kategorie zur Liste hinzu.
     * @param category die neue Kategorie
     */
    public void addCategory(String category) {
        if (category != null && !category.isEmpty() && !categories.contains(category)) {
            categories.add(category); // Neue Kategorie hinzufügen, wenn sie nicht bereits existiert
        }
    }
    
}
