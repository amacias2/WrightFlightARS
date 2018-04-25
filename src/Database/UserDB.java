package Database;

import BusinessLogic.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB extends Application {

	public static Connection getConnection() throws Exception{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
				"root");
		return connection;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void addUser(User a) throws Exception {

		
		try {
			Connection connection = getConnection();
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

		try {
			Connection connection = getConnection();
			
			try {
				// select query to run
				String str = "select CPassword from Customer" + "where CUsername='"+ username+"';";

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				
				while(resultSet.next()) {
				return resultSet.getString(1);
				}

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return "No password found";
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
