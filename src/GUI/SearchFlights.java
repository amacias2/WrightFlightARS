package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.Booking;
import BusinessLogic.Customer;
import BusinessLogic.Flight;
import Database.CustomerDB;
import Database.FlightDB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchFlights extends Application implements EventHandler<ActionEvent> {
	private static String bookFlightID = "";

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Search Flights");
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		ChoiceBox<String> dropdown = new ChoiceBox<>();
		dropdown.getItems().addAll("To", "From", "Date", "Time", "Airline");
		dropdown.setValue("To");
		dropdown.setLayoutY(60);
		dropdown.setLayoutX(720);

		Button userView = new Button("Main page");
		userView.setOnAction(a -> {
			// main user page
			// add try and catch
		});

		TextField search = new TextField();
		search.setLayoutX(800);
		search.setLayoutY(60.0);
		search.setMinWidth(250);

		TableColumn<Flight, String> column1 = new TableColumn<Flight, String>("Flight#");
		column1.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		column1.setMinWidth(80);
		TableColumn<Flight, StringBuilder> column2 = new TableColumn<Flight, StringBuilder>("Departure Date");
		column2.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		column2.setMinWidth(100);
		TableColumn<Flight, StringBuilder> column3 = new TableColumn<Flight, StringBuilder>("Departure Time");
		column3.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		column3.setMinWidth(100);
		TableColumn<Flight, StringBuilder> column4 = new TableColumn<Flight, StringBuilder>("Arrival Time");
		column4.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column4.setMinWidth(100);
		TableColumn<Flight, StringBuilder> column5 = new TableColumn<Flight, StringBuilder>("Flight Duration");
		column5.setCellValueFactory(new PropertyValueFactory<>("flightDuration"));
		column5.setMinWidth(100);
		TableColumn<Flight, String> column6 = new TableColumn<Flight, String>("To");
		column6.setCellValueFactory(new PropertyValueFactory<>("to"));
		column6.setMinWidth(115);
		TableColumn<Flight, String> column7 = new TableColumn<Flight, String>("From");
		column7.setCellValueFactory(new PropertyValueFactory<>("from"));
		column7.setMinWidth(115);
		TableColumn<Flight, String> column8 = new TableColumn<Flight, String>("Airline");
		column8.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
		column8.setMinWidth(120);
		TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Capacity");
		column9.setCellValueFactory(new PropertyValueFactory<>("capacity"));
		column9.setMinWidth(75);
		TableColumn<Flight, Integer> column10 = new TableColumn<Flight, Integer>("#Booked");
		column10.setCellValueFactory(new PropertyValueFactory<>("numBooked"));
		column10.setMinWidth(75);
		TableColumn<Flight, String> column11 = new TableColumn<Flight, String>("Destination Airport");
		column11.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));
		column11.setMinWidth(128.88);
		TableColumn<Flight, Double> column12 = new TableColumn<Flight, Double>("Flight Price");
		column12.setCellValueFactory(new PropertyValueFactory<>("flight_price"));
		column12.setMinWidth(80);
		TableColumn<Flight, StringBuilder> column13 = new TableColumn<Flight, StringBuilder>("Boarding Time");
		column13.setCellValueFactory(new PropertyValueFactory<>("boardingTime"));
		column13.setMinWidth(110);

		table.setTableMenuButtonVisible(false);

		Button searchB = new Button("Search Flights");
		searchB.setLayoutX(1050);
		searchB.setLayoutY(60.0);
		searchB.setMinWidth(100);

		searchB.setOnAction(s -> {
			try {
				String dbSearch = getChoice(dropdown).trim();

				String searchItem = search.getText().trim().toUpperCase();
				if (dbSearch == "fDate" && !searchItem.matches("\\d{2}-\\d{2}-\\d{4}")) {
					AlertMessage.display("Search Error", "Please insert date as MM-DD-YYYY and try again.");
				}
				if (dbSearch == "DepartureTime" && !searchItem.matches("\\d{2}:\\d{2}")) {
					AlertMessage.display("Search Error",
							"Please insert time as HH:MM (23:59 = 11:59 PM) and try again.");
				}

				Connection connection = getConnection();

				String str = "SELECT * FROM Flight WHERE " + dbSearch + "= '" + searchItem + "';";
				PreparedStatement statement = connection.prepareStatement(str);

				ResultSet myResult = statement.executeQuery();
				table.getItems().clear();

				if (!myResult.next()) {
					AlertMessage.display("No Flights Found",
							"No flights were found matching your criteria. Please try again. "
									+ "\nFormat for searches-\nTo/From: City STATE ex. Atlanta GA\nDate:MM-DD-YYYY\nTime: HH:MM ex. 17:45");
				}
				while (myResult.next()) {
					data.add(new Flight(myResult.getString("flightNum"), myResult.getString("fDate"),
							myResult.getString("DepartureTime"), myResult.getString("ArrivalTime"),
							myResult.getString("FlightDuration"), myResult.getString("fTo"),
							myResult.getString("fFrom"), myResult.getString("AirlineName"), myResult.getInt("capacity"),
							myResult.getInt("BookedNum"), myResult.getString("DestinationAirport"),
							myResult.getString("Flight_Price"), myResult.getString("BoardingTime")));
					table.setItems(data);
				}

				statement.close();
				myResult.close();
				connection.close();

			} catch (SQLException a) {
				System.out.println(a.getMessage());
			}
		});

		table.setLayoutX(20);
		table.setLayoutY(100);
		table.setMinWidth(1000);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
				column10, column11, column12, column13);
		anchor.getChildren().addAll(dropdown, search, searchB, table, userView);
		Scene scene = new Scene(anchor, 1300, 700);

		TextField flightIDText = new TextField();
		flightIDText.setPromptText("Flight ID");
		Button bkFlight = new Button("Book Flight");
		bookFlightID = flightIDText.getText();

		bkFlight.setOnAction(f -> {
			
			Connection connection=getConnection();
			
			String Cssn= CustomerDB.getUserSSN(homepage.usr);
			
			String checkDoubleBooked="SELECT flightID, cSSN FROM booking where cSSN="+Cssn+"';";
			
		
		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void handle(ActionEvent arg0) {

	}

	// test
	public String getChoice(ChoiceBox<String> dropdown) {
		String dbSearch = "";
		String choice = dropdown.getValue();
		switch (choice) {
		case "To":
			dbSearch = "fTo";
			break;
		case "From":
			dbSearch = "fFrom";
			break;
		case "Date":
			dbSearch = "fDate";
			break;
		case "Time":
			dbSearch = "DepartureTime";
			break;
		case "Airline":
			dbSearch = "AirlineName";
		}
		return dbSearch;
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
