package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	public HelloServlet() {

	}

	public void init(ServletConfig config) throws ServletException {

		System.out.println("*********************************");
		System.out.println("*** Servelt initiation sucess ***");
		System.out.println("*********************************");
	}

	public void destroy() {

	}
 
	public ServletConfig getServletConfig() {

		return null;
	}

	public String getServletInfo() {

		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println(" Server Tested sucessfully");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("Server repsonse working ");
		out.println("<html>");
		out.println("<head>");

		out.println("<style>");
		out.println("body { background-color: lightblue; }");

		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>servlet response Page</h1>");
		out.println("<p>code has written using HTML</p>");
		out.println("</body>");
		out.println("</html>");

	}

}
