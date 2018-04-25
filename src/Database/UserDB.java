package Database;

import BusinessLogic.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {

	public static void addUser(User a) {

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
				String str = "Insert into Customer Values('" + a.getSsn() + "','" + a.getUsername() + "','"
						+ a.getPassword() + "','" + a.getFirstName() + "', '" + a.getMidName() + "', '"
						+ a.getLastName() + "', '" + a.getStreet() + "', '" + a.getZipCode() + "', '" + a.getState()
						+ "','" + a.getCountry() + "','" + a.getEmail() + "', '" + a.getSecurityQ() + "','"
						+ a.getSecurityA() + "');";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				statement.executeUpdate(str);

			} catch (Exception ex) {
				// send to gui error dialog box
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

	public static String getUserPW(String username) {

		// Load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver loaded");

		try {
			// Connect
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false",
					"root", "root");
			System.out.println("DBMS connected");
			try {
				// select query to run
				String str = "select cpassword from Customer" + "where cusername='" + username + "';";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				ResultSet resultSet = statement.executeQuery(str);

				return resultSet.toString();
			}

			catch (Exception ex) {
			} finally {
				connection.close();
			}
		} catch (Exception ex) {

		}
		return "No password found";

	}



}
