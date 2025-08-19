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
    <% 
    List<TodoEntry> todoList = (List<TodoEntry>) request.getAttribute("todoList");
        if (todoList != null) {
            for (TodoEntry todoEntry : todoList) { 
    %>
                    <div class="todo-entry">
                    <p><%= todoEntry.getTodoTitle() %></p> <!-- Zeigt den Namen des Todo-Eintrags an -->
                    <p>Kategorie: <%= todoEntry.getTodoCategory() != null ? todoEntry.getTodoCategory() : "Keine" %></p> <!-- Optionale Kategorie -->
                    <p>Fälligkeitsdatum: <%= todoEntry.getTodoDueDate() != null ? todoEntry.getTodoDueDate() : "Nicht festgelegt" %></p> <!-- Optionales Fälligkeitsdatum -->
                    <p>Wichtig: <%= todoEntry.getTodoIsImportant() ? "Ja" : "Nein" %></p> <!-- Markierung als wichtig -->
                    <p>Abgeschlossen: <%= todoEntry.getTodoIsCompleted() ? "Ja" : "Nein" %></p> <!-- Markierung als abgeschlossen -->
                    <form method='post' action='todo' style="display:inline;">
                        <input type='hidden' name='todoId' value='<%= todoEntry.getId() %>' /> <!-- ID des Todo-Eintrags -->
                        <input type='hidden' name='action' value='remove' /> <!-- Aktion zum Entfernen -->
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
        <input type='text' name='category' /> <!-- Optionale Kategorie -->
        <label>Fälligkeitsdatum:</label>
        <input type='date' name='dueDate' /> <!-- Optionales Fälligkeitsdatum -->
        <label>Wichtig:</label>
        <input type='checkbox' name='isImportant' /> <!-- Markierung als wichtig -->
        <label>Abgeschlossen:</label>
        <input type='checkbox' name='isCompleted' /> <!-- Markierung als abgeschlossen -->
        <input type='hidden' name='action' value='add' /> <!-- Aktion zum Hinzufügen -->
        <input type='submit' value='Hinzufügen' />
    </form>
</body>
</html>
</body>
</html>
