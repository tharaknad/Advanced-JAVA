package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Loginservlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        try {
            if (LoginDao.validateUserData(username, password)) {
            	out.println("<html>");
                out.println("<body>");
                out.println("<h1>Welcome user </h1>");
                out.println("</body>");
                out.println("</html>");
                
            } else {
                
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>Invalid username or password</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }
}
