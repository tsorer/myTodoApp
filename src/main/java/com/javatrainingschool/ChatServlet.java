package com.javatrainingschool;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static List<String> messages = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Chat Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Chat Messages:</h1>");
        
        for (String message : messages) {
            out.println("<p>" + message + "</p>");
        }
        
        out.println("<form method='post'>");
        out.println("<label>Your Message:</label>");
        out.println("<input type='text' name='message' />");
        out.println("<input type='submit' value='post' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        if (message != null && !message.trim().isEmpty()) {
            messages.add(message);
        }
        response.sendRedirect("chat");
    }
}
