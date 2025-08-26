package com.javatrainingschool.controller;
import com.javatrainingschool.model.TodoList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        request.setAttribute("categories", todoList.getCategories());
        
        // 2. An die View (JSP) weiterleiten
        // Der Controller entscheidet, welche View die Daten anzeigen soll
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String message = request.getParameter("message");
            String category = request.getParameter("category");
            
            String newCategory = request.getParameter("newCategory"); // Neue Kategorie

            if (newCategory != null && !newCategory.isEmpty()) {
                todoList.getCategories().add(newCategory); // Neue Kategorie zur Liste hinzufügen
                category = newCategory; // Verwende die neue Kategorie
            }
            
            String dueDateStr = request.getParameter("dueDate");
            boolean isImportant = request.getParameter("isImportant") != null;
            boolean isCompleted = request.getParameter("isCompleted") != null;
           
            
            // Konvertiere das Fälligkeitsdatum von String zu Date
            Date dueDate = null;
            if (dueDateStr != null && !dueDateStr.isEmpty()) {
                try {
                    dueDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr);
                } catch (ParseException e) {
                    e.printStackTrace(); // Fehlerbehandlung
                }
            }
            
            
            todoList.addTodoEntry(message, category, dueDate, isImportant, isCompleted);

        } else if ("remove".equals(action)) {
            int todoId = Integer.parseInt(request.getParameter("todoId"));
            todoList.removeTodoEntry(todoId);
        }

        response.sendRedirect("todo");
    }
}