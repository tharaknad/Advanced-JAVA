package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// loading class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// creating connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle1");

		// create statement
		Statement stm = con.createStatement();

		// query for database
		String s = "SELECT * FROM employee \r\n" + "where emp_id=2";
		ResultSet r = stm.executeQuery(s);

		// load data from database

		while (r.next()) {  
			System.out.println(r.getInt(1) + " " + r.getString(2) + " " + r.getInt(3));
		}

	}

}
