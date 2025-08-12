<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="com.javatrainingschool.model.TodoEntry" %>


<!DOCTYPE html>
<html>
<head>
    <title>Welcome to MyTodoList!</title>
</head>
<body>
    <h1>TodoList:</h1>
    <% 
    List<TodoEntry> todoList = (List<TodoEntry>) request.getAttribute("todoList");
        if (todoList != null) {
            for (TodoEntry todoEntry : todoList) { 
    %>
                <p><%= todoEntry %></p>
    <% 
            }
        } 
    %>
    <form method='post' action='todo'>
        <label>New Todo:</label>
        <input type='text' name='message' />
        <input type='submit' value='post' />
    </form>
</body>
</html>

