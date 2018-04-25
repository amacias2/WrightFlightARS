package Database;
import BusinessLogic.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightDB {
	public static void addFlight(Flight a) {
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
			String str = "Insert into Flight Values('" + a.getFlightID() + "','" + a.getFlightNum() + "','"
					+ a.getDepartureDate() + "','" + a.getTo() + "', '" + a.getFrom() + "', '"
					+ a.getBoardingTime() + "', '" + a.getDepartureTime() + "', '" + a.getArrivalTime() + "', '" + a.getFlightDuration()
					+ "','" + a.getDestinationAirport() + "','" + a.getAirlineName() + "', '" + a.getCapacity()+ "','"+ a.getNumBooked() + "','"
					+ a.getFlight_price() + "');";

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

}}
