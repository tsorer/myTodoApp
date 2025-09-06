<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.javatrainingschool.model.TodoEntry" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome to MyTodoList!</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css"> <!-- Link zur CSS-Datei -->
</head>
<body>
    <h1>TodoList:</h1>

    <!-- Filterformular -->
    <form method='get' action='todo'>
        <label>Kategorie filtern:</label>
        <select name='filterCategory'>
            <option value=''>Alle Kategorien</option>
            <% 
            List<String> filterCategories = (List<String>) request.getAttribute("categories"); // Umbenennung
            if (filterCategories != null) {
                for (String category : filterCategories) { 
            %>
                <option value='<%= category %>'><%= category %></option>
            <% 
                }
            } 
            %>
        </select>
        
        <label>Nur wichtige Todos:</label>
        <input type='checkbox' name='filterImportant' />
        
        <input type='submit' value='Filtern' />
    </form>

<% 
List<TodoEntry> todoList = (List<TodoEntry>) request.getAttribute("todoList");
if (todoList != null) {
    for (TodoEntry todoEntry : todoList) { 
        boolean isOverdue = todoEntry.isOverdue(); // Überprüfung auf Überfälligkeit
%>
        <div class="todo-entry <%= isOverdue ? "overdue-highlight" : "" %>"> <!-- Füge die overdue-highlight-Klasse hinzu, wenn überfällig -->
            <p><%= todoEntry.getTodoTitle() %></p>
            <p>Kategorie: <%= todoEntry.getTodoCategory() != null ? todoEntry.getTodoCategory() : "Keine" %></p>
            <p>Fälligkeitsdatum: <%= todoEntry.getFormattedDueDate() != null ? todoEntry.getFormattedDueDate() : "Nicht festgelegt" %></p>
            
            <p>Wichtig: <%= todoEntry.getTodoIsImportant() ? "Ja" : "Nein" %></p>
            <p>Abgeschlossen: <%= todoEntry.getTodoIsCompleted() ? "Ja" : "Nein" %></p>
            <form method='post' action='todo' style="display:inline;">
                <input type='hidden' name='todoId' value='<%= todoEntry.getId() %>' />
                <input type='hidden' name='action' value='remove' />
                <input type='submit' value='Entfernen' />
            </form>
        </div>
<% 
    }
} 
%>

    <form method='post' action='todo'>
        <label>Neues Todo:</label>
        <input type='text' name='message' required />
        
        <label>Kategorie:</label>
        <select name='category'>
            <option value=''>Bitte wählen</option>
            <% 
            List<String> addCategories = (List<String>) request.getAttribute("categories"); // Umbenennung
            if (addCategories != null) {
                for (String category : addCategories) { 
            %>
                <option value='<%= category %>'><%= category %></option>
            <% 
                }
            } 
            %>
        </select>
        <input type='text' id='newCategory' name='newCategory' placeholder='Neue Kategorie hinzufügen' />
        
        <label>Fälligkeitsdatum:</label>
        <input type='date' name='dueDate' />
        
        <label>Wichtig:</label>
        <input type='checkbox' name='isImportant' />
        
        <label>Abgeschlossen:</label>
        <input type='checkbox' name='isCompleted' />
        
        <input type='hidden' name='action' value='add' />
        <input type='submit' value='Hinzufügen' />
    </form>
</body>
</html>
