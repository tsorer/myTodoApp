package com.javatrainingschool.controller;
import com.javatrainingschool.model.TodoEntry;
import com.javatrainingschool.model.TodoList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    	 response.setContentType("text/html; charset=UTF-8");
    	 response.setCharacterEncoding("UTF-8"); // Setze die Zeichencodierung
    	 

    	
        // 1. Daten vom Model abrufen
        List<TodoEntry> todoList = this.todoList.showTodoList();
        request.setAttribute("categories", this.todoList.getCategories());
    	
        // 2. Filterparameter abrufen
        String filterCategory = request.getParameter("filterCategory");
        boolean filterImportant = request.getParameter("filterImportant") != null;
    	
        
        // 3. Todo-Liste filtern
        List<TodoEntry> filteredTodos = this.todoList.filterTodoList(filterCategory, filterImportant); 
        
        // 4. Todo-Liste sortieren
        List<TodoEntry> sortedTodos = this.todoList.getSortedTodoList(filteredTodos); // Verwende die neue Methode
        
        // 4. Gefilterte Liste an die View weiterleiten
        request.setAttribute("todoList", sortedTodos);
        
        // 5. An die View (JSP) weiterleiten
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // Setze die Zeichencodierung für die Anfrage
        response.setContentType("text/html; charset=UTF-8"); // Setze den Content-Type für die Antwort
    	
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