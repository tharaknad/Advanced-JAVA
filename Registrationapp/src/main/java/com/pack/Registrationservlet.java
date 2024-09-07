package com.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registrationservlet() {

		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String gender = request.getParameter("gender");
		String contract = request.getParameter("contract");
		String address = request.getParameter("address");
		String password = request.getParameter("password");

		RegisterDTO reg = new RegisterDTO();
		reg.setId(id1);
		reg.setFname(fname);
		reg.setLname(lname);
		reg.setUname(uname);
		reg.setGender(gender);
		reg.setContract(contract);
		reg.setAddress(address);
		reg.setPassword(password);

		try {
			if (RegistrationDAO.details(reg)) {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Sucessfully registered</h1>");
				out.println("</body>");
				out.println("</html>");
			} else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Registration failed: ID already exists</h1>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
