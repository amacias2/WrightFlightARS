package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;

import GUI.homepage;

public class BookingDB {

	public static boolean checkDoubleBooked(String flightID,String username) {
		try {
			Connection connection = getConnection();
			
			try {
				String Cssn= CustomerDB.getUserSSN(homepage.getUsr());
				// select query to run
				String str="SELECT flightID, cSSN FROM booking where cSSN="+Cssn+"';";
				

				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				
				ResultSet resultSet = statement.executeQuery(str);
				if(!resultSet.next()) {
					return false;
				}else
					return true;

			} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return true;
	}
	
	public static boolean checkConflict(String flightID,String username) {
		try {
			Connection connection = getConnection();
			
			try {
				String Cssn= CustomerDB.getUserSSN(homepage.getUsr());
				// select query to run
				String str1="SELECT flightID, DepartureTime,ArrivalTime FROM Flight inner join booking on "+Cssn+"booking.cssn';";
				
				String str2="SELECT DepartureTime, ArrivalTime, FROM flight where flightID='"+flightID+"';";
				

				// Prepare Statement
				Statement statement1 = connection.prepareStatement(str1);
				Statement statement2 = connection.prepareStatement(str2);

				// Execute Statement
				
				ResultSet resultSet1 = statement1.executeQuery(str1);
				ResultSet resultSet2 = statement2.executeQuery(str2);
				while(resultSet1.next()) {
				
					if(LocalTime.parse(resultSet1.getString("DepartureTime")).isAfter(LocalTime.parse(resultSet2.getString("DepartureTime")))&& LocalTime.parse(resultSet1.getString("DepartureTime")).isBefore(LocalTime.parse(resultSet2.getString("ArrivalTime")))) {
						return true;
					}

			}} catch (Exception ex) {

			} finally {
				connection.close();
			}

		} catch (Exception e) {
		}
		return false;
	}
	
	
	
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

}
