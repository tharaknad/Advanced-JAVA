package com.pack1;

import java.sql.*;

public class LoginDao {

	public static boolean validateUserData(String username, String password)
			throws ClassNotFoundException, SQLException {

		boolean status = false;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle1");

			String sql = "SELECT * FROM employee_detail WHERE name = ? AND pass = ?";
			st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			
			status = st.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return status;
	}
}
