package com.pack1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		if (username.equalsIgnoreCase("admin") && password.equals("1234")) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Welcome to user page</h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("Invalid credentials");
		}

	}

}
