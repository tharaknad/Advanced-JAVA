package application;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Loginservlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public Loginservlet() {
		super();
	}
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
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
