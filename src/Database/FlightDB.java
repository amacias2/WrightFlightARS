package Database;

import BusinessLogic.Flight;
import GUI.AlertMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightDB {
	public static void addFlight(Flight a) {
		try {
			Connection connection = getConnection();
			// select query to run
			String str = "Insert into Flight Values('" + a.getFlightID() + "','" + a.getFlightNum() + "','"
					+ a.getDepartureDate() + "','" + a.getTo() + "', '" + a.getFrom() + "', '" + a.getBoardingTime()
					+ "', '" + a.getDepartureTime() + "', '" + a.getArrivalTime() + "', '" + a.getFlightDuration()
					+ "','" + a.getDestinationAirport() + "','" + a.getAirlineName() + "', '" + a.getCapacity() + "','"
					+ a.getNumBooked() + "','" + a.getFlight_price() + "');";

			// Prepare Statement
			Statement statement = connection.prepareStatement(str);

			// Execute Statement
			statement.executeUpdate(str);
			connection.close();
		} catch (Exception ex) {
			// send to gui error dialog box
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
					"root");
		} catch (Exception e) {
			System.out.println("Cannot connect");
		}
		return connection;

	}
}
