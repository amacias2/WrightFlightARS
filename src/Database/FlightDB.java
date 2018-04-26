package Database;
import BusinessLogic.Flight;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	}
	public static void searchflight(String toText,String toState, String fromText, String fromState, String month, String day, String year,String time,String am_pm ) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		// Connect
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
					"root");
			
			try {
				// select query to run
				String str = "SELECT * FROM Flight"
						+ " Where fTo like'\\%"+toText+"\\%"+toState+"\\%' AND"
						+" fFrom like'\\%"+fromText+"\\%"+fromState+"\\%' AND"
						+" fDate like'\\%"+month+"\\%"+day+"\\%" +year+"\\%' AND"
						+" DepartureTime like'\\%"+time+"\\%"+am_pm+"'";
						
				
				// Prepare Statement
				Statement statement = connection.prepareStatement(str);

				// Execute Statement
				ResultSet resultSet= statement.executeQuery(str);
				
				while(resultSet.next()) {
					System.out.println(resultSet.getString("flightID") +" "+resultSet.getString("flightNum") +" "+resultSet.getString("fDate") +" "+resultSet.getString("fTo") +" "+resultSet.getString("fFrom") +" "+resultSet.getString("BoardingTime") +" "+resultSet.getString("DepartureTime") +" "+resultSet.getString("ArrivalTime") +" "+resultSet.getString("FlightDuration") +" "+resultSet.getString("DestinationAirport") +" "+resultSet.getString(11) +" "+resultSet.getString("AirlineName") +" "+resultSet.getString("Capacity") +" "+resultSet.getString("BookedNum")+resultSet.getString("Flight_Price"));

			}} catch (Exception ex) {
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

}
