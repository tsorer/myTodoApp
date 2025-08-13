package com.javatrainingschool.controller;
import com.javatrainingschool.model.TodoList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Eine Instanz des Models, um Daten zu verarbeiten
    private TodoList todoList = new TodoList();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Daten vom Model abrufen
        // Die Nachrichtenliste wird vom Model geholt
        request.setAttribute("todoList", todoList.showTodoList());
        
        // 2. An die View (JSP) weiterleiten
        // Der Controller entscheidet, welche View die Daten anzeigen soll
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String message = request.getParameter("message");
            todoList.addTodoEntry(message);
        } else if ("remove".equals(action)) {
            int todoId = Integer.parseInt(request.getParameter("todoId"));
            todoList.removeTodoEntry(todoId);
        }

        response.sendRedirect("todo");
    }
}