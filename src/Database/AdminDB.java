package Database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.Admin;

public class AdminDB {
	public static void addAdmin(Admin a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println("Driver loaded");

		// Connect
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
					"root");
			try {
				// select query to run
				String str = "Insert into Flight Values('" + a.getUsername() + "','" + a.getPassword() + "','"
						+ a.getFirstName() + "','" + a.getMidName() + "', '" + a.getLastName() + "', '" + a.getStreet()
						+ "', '" + a.getZipCode() + "', '" + a.getState() + "', '" + a.getCountry() + "','"
						+ a.getEmail() + "','" + a.getSecurityQ() + "', '" + a.getSecurityA() + "');";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);

			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	
	
}
