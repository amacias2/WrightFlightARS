package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.Flight;
import Database.AdminDB;
import Database.BookingDB;
import Database.CustomerDB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class viewBookings extends Application implements EventHandler<ActionEvent>{
	
	
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("View Booked Flights");
		AnchorPane anchor = new AnchorPane();
		anchor.setPadding(new Insets(20, 20, 20, 20));
		TableView<Flight> table = new TableView<>();
		final ObservableList<Flight> data = FXCollections.observableArrayList();

		
		Button userView = new Button("Main page");
		userView.setOnAction(a -> {
			if (AdminDB.isAdmin(homepage.getUsr())) {
				primaryStage.close();
				AdminMain main = new AdminMain();
				main.start(new Stage());
			} else {
				primaryStage.close();
				CustomerMain cmain = new CustomerMain();
				cmain.start(new Stage());

			}
		});
		
		TableColumn<Flight, String> column1 = new TableColumn<Flight, String>("Flight#");
		column1.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
		column1.setMinWidth(80);
		TableColumn<Flight, String> column2 = new TableColumn<Flight, String>("Departure Date");
		column2.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
		column2.setMinWidth(100);
		TableColumn<Flight, String> column3 = new TableColumn<Flight, String>("Departure Time");
		column3.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
		column3.setMinWidth(100);
		TableColumn<Flight, String> column4 = new TableColumn<Flight, String>("Arrival Time");
		column4.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		column4.setMinWidth(100);
		TableColumn<Flight, String> column5 = new TableColumn<Flight, String>("Flight Duration");
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
		column8.setMinWidth(80);
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
		TableColumn<Flight, String> column13 = new TableColumn<Flight, String>("Boarding Time");
		column13.setCellValueFactory(new PropertyValueFactory<>("boardingTime"));
		column13.setMinWidth(110);
		table.setTableMenuButtonVisible(false);
		TableColumn<Flight, String> column14 = new TableColumn<Flight, String>("FlightID");
		column14.setCellValueFactory(new PropertyValueFactory<>("flightID"));
		column14.setMinWidth(80);
		
		Button searchB = new Button("Search Flights");
		searchB.setLayoutX(1050);
		searchB.setLayoutY(60.0);
		searchB.setMinWidth(100);

		searchB.setOnAction(s -> {
			
					try {
						Connection connection = getConnection();
					String str = "SELECT * FROM Booking WHERE Cssn = '" + CustomerDB.getUserSSN(homepage.getUsr()) + "';";
					PreparedStatement statement = connection.prepareStatement(str);

					ResultSet myResult = statement.executeQuery();
					table.getItems().clear();

					if (!myResult.next()) {
						AlertMessage.display("No Flights Found",
								"No flights were found");
					}
					while (myResult.next()) {
						data.add(new Flight(myResult.getString("flightNum"), myResult.getString("fDate"),
								myResult.getString("DepartureTime"), myResult.getString("ArrivalTime"),
								myResult.getString("FlightDuration"), myResult.getString("fTo"),
								myResult.getString("fFrom"), myResult.getString("AirlineName"),
								myResult.getInt("capacity"), myResult.getInt("BookedNum"),
								myResult.getString("DestinationAirport"), myResult.getString("Flight_Price"),
								myResult.getString("BoardingTime"), myResult.getString(1)));
						table.setItems(data);
					}
					statement.close();
					myResult.close();
					connection.close();
					

				} catch (SQLException a) {
					System.out.println(a.getMessage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					} 
				
			});

		table.setLayoutX(20);
		table.setLayoutY(100);
		table.setMinWidth(1020);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9,
				column10, column11, column12, column13, column14);
		anchor.getChildren().addAll( searchB, table, userView);
		Scene scene = new Scene(anchor, 1600, 900);

		

		primaryStage.setScene(scene);
		primaryStage.show();
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
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
		
		
}
