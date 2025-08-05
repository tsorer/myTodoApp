package com.javatrainingschool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<String> todoList = new ArrayList<>(); // Liste für die Einträge

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        // HTML-Inhalt
        pw.println("<html><body>");
        pw.println("<h1>Willkommen zu meiner ersten TodoApp</h1>");

        // Formular zum Hinzufügen eines Eintrags
        pw.println("<form method='POST' action='FirstServlet'>");
        pw.println("Neuer Eintrag: <input type='text' name='todoItem' required>");
        pw.println("<input type='submit' value='Hinzufügen'>");
        pw.println("</form>");

        // Liste der Einträge anzeigen
        pw.println("<h2>Todo-Liste:</h2>");
        pw.println("<ul>");
        for (String item : todoList) {
            pw.println("<li>" + item + "</li>");
        }
        pw.println("</ul>");

        pw.println("</body></html>");
        pw.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String todoItem = req.getParameter("todoItem");
        if (todoItem != null && !todoItem.trim().isEmpty()) {
            todoList.add(todoItem);
        }
        // Weiterleitung zur GET-Methode, um die aktualisierte Liste anzuzeigen
        res.sendRedirect("FirstServlet");
    }
}
