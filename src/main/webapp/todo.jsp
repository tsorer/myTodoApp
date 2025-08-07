<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> 
<%@ page import="java.util.ArrayList" %> 

<!DOCTYPE html>
<html>
<head>
    <title>Welcome to MyTodoList!</title>
</head>
<body>
    <h1>TodoList:</h1>
    <% 
        List<String> messages = (List<String>) request.getAttribute("messages");
        if (messages != null) {
            for (String message : messages) { 
    %>
                <p><%= message %></p>
    <% 
            }
        } 
    %>
    <form method='post' action='chat'>
        <label>New Todo:</label>
        <input type='text' name='message' />
        <input type='submit' value='post' />
    </form>
</body>
</html>

