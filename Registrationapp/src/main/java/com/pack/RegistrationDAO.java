package com.pack;

import java.sql.*;

public class RegistrationDAO {

	public static boolean details(RegisterDTO registerdto) throws ClassNotFoundException, SQLException {
		boolean status = false;

		String insert = "INSERT INTO user_reg values (?,?,?,?,?,?,?,?)";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle1");

			// CheckSt is to check the "id" is already existing or not
			PreparedStatement checkSt = con.prepareStatement("SELECT id FROM user_reg WHERE id = ?");
			checkSt.setInt(1, registerdto.getId());
			ResultSet rS = checkSt.executeQuery();
			if (rS.next()) {
				// If ID already exists.
				status = false;
				System.out.println("ID already exists. Please choose a different ID.");
			} else {
				// If ID doesn't exist
				PreparedStatement pt = con.prepareStatement(insert);
				pt.setInt(1, registerdto.getId());
				pt.setString(2, registerdto.getFname());
				pt.setString(3, registerdto.getLname());
				pt.setString(4, registerdto.getUname());
				pt.setString(5, registerdto.getGender());
				pt.setString(6, registerdto.getContract());
				pt.setString(7, registerdto.getAddress());
				pt.setString(8, registerdto.getPassword());

				result = pt.executeUpdate();
				if (result > 0) {
					status = true;
					System.out.println("Inserted");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
