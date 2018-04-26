package GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.Booking;
import BusinessLogic.Customer;
import BusinessLogic.Flight;
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

public abstract class SearchFlights extends Application implements EventHandler<ActionEvent>{
	public static void main(String[]args) {
		launch(args);
	}

@Override
public void start(Stage primaryStage) throws Exception{
	primaryStage.setTitle("Search Flights");
	AnchorPane anchor= new AnchorPane();
	anchor.setPadding(new Insets(20,20,20,20));
	TableView<Flight> table = new TableView<>();
	final ObservableList<Flight>data=FXCollections.observableArrayList();
	
	ChoiceBox<String> dropdown= new ChoiceBox<>();
	dropdown.getItems().addAll("To","From","Date","Time","Airline");
	dropdown.setValue("To");
	dropdown.setLayoutY(60);
	dropdown.setLayoutX(340);
	
	Button userView= new Button("Main page");
	userView.setOnAction(a->{
		//main user page
		//add try and catch
	});
	userView.setLayoutX(970);
	userView.setLayoutY(60);
	userView.setMinWidth(100);
	
	Button logout= new Button("Log Out");
	logout.setOnAction(b->{
		homepage hpage=new homepage();
		try {
			hpage.start(primaryStage);
		}catch(Exception e){
			e.printStackTrace();
		}
	});
	logout.setLayoutX(970);
	logout.setLayoutY(60);
	logout.setMinWidth(100);
	
	Label username=new Label();
	username.setAlignment(javafx.geometry.Pos.CENTER);
	username.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
	username.setLayoutX(900.0);
	username.setLayoutY(10.0);
	username.setText("Logged in as: "+ Customer.getUsername());
	username.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
	username.setFont(new Font(20.0));
	
	TextField search= new TextField();
	search.setLayoutX(1000);
	search.setLayoutY(60.0);
	search.setMinWidth(250);
	
	TableColumn<Flight, String> column1 = new TableColumn<Flight, String>("Flight Number");
	column1.setCellValueFactory(new PropertyValueFactory<>("flightNum"));
	column1.setMinWidth(128.88);
	TableColumn<Flight, StringBuilder> column2 = new TableColumn<Flight, StringBuilder>("Departure Date");
	column2.setCellValueFactory(new PropertyValueFactory<>("departureDate"));
	column2.setMinWidth(128.88);
	TableColumn<Flight, StringBuilder> column3 = new TableColumn<Flight, StringBuilder>("Departure Time");
	column3.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
	column3.setMinWidth(128.88);
	TableColumn<Flight, StringBuilder> column4 = new TableColumn<Flight, StringBuilder>("Arrival Time");
	column4.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
	column4.setMinWidth(128.88);
	TableColumn<Flight, StringBuilder> column5 = new TableColumn<Flight, StringBuilder>("Flight Duration");
	column5.setCellValueFactory(new PropertyValueFactory<>("flightDuration"));
	column5.setMinWidth(128.88);
	TableColumn<Flight, String> column6 = new TableColumn<Flight, String>("To");
	column6.setCellValueFactory(new PropertyValueFactory<>("to"));
	column6.setMinWidth(128.88);
	TableColumn<Flight, String> column7 = new TableColumn<Flight, String>("From");
	column7.setCellValueFactory(new PropertyValueFactory<>("from"));
	column7.setMinWidth(128.88);
	TableColumn<Flight, String> column8 = new TableColumn<Flight, String>("Airline Name");
	column8.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
	column8.setMinWidth(128.88);
	TableColumn<Flight, Integer> column9 = new TableColumn<Flight, Integer>("Capacity");
	column9.setCellValueFactory(new PropertyValueFactory<>("capacity"));
	column9.setMinWidth(128.88);
	TableColumn<Flight, Integer> column10 = new TableColumn<Flight, Integer>("Number Booked");
	column10.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
	column10.setMinWidth(128.88);
	TableColumn<Flight, String> column11 = new TableColumn<Flight, String>("Destination Airport");
	column11.setCellValueFactory(new PropertyValueFactory<>("destinationAirport"));
	column11.setMinWidth(128.88);
	TableColumn<Flight, Double> column12 = new TableColumn<Flight, Double>("Flight Price");
	column12.setCellValueFactory(new PropertyValueFactory<>("flight_price"));
	column12.setMinWidth(128.88);
	TableColumn<Flight, StringBuilder> column13 = new TableColumn<Flight, StringBuilder>("Bording Time");
	column13.setCellValueFactory(new PropertyValueFactory<>("boardingTime"));
	column13.setMinWidth(128.88);
	
	table.setTableMenuButtonVisible(false);
	
	Button searchB=new Button("Search Flights");
	searchB.setOnAction(s->{
		try {
		String dbSearch = getChoice(dropdown).trim();
		String searchItem= search.getText().trim();
		
		Connection connection = getConnection();
		
		String sql="SELECT * FROM Flights.flight WHERE " + dbSearch + " = '" + searchItem + "'";
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet myResult;
		myResult=statement.executeQuery();
		table.getItems().clear();
		
		while(myResult.next()) {
			//data printed
		}
		statement.close();
		myResult.close();
		connection.close();
		
	} catch(SQLException a){
		System.out.println(a.getMessage());
	}});
	
	table.setLayoutX(20);
	table.setLayoutY(100);
	table.setMinWidth(1000);
	table.getColumns().addAll(column1,column2, column3, column4, column5, column6, column7, column8, column9,column10,column11,column12,column13);
	anchor.getChildren().addAll(dropdown, username, search, searchB, table, userView, logout);
	Scene scene= new Scene(anchor,1300,700);
	
	primaryStage.setScene(scene);
	primaryStage.show();
}
public void handle(ActionEvent arg0) {
	
}
//test
public String getChoice(ChoiceBox<String>dropdown) {
	String dbSearch="";
	String choice= dropdown.getValue();
	if(choice.equals("To")) {
		dbSearch="fTo";
	}else if(choice.equals("From")) {
		dbSearch="fFrom";
	}else if(choice.equals("Date")) {
		dbSearch="fDate";
	}else if(choice.equals("Time")) {
		dbSearch="DepartureTime";
	}else if(choice.equals("Airline")) {
		dbSearch="AirlineName";
	}
	return dbSearch;
}
/*public int conflictCheck(StringBuilder DepartureTime, StringBuilder ArrivalTime,) {
	
}*/
	public static Connection getConnection() {
		Connection connection=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/WrightFlights?useSSL=false", "root",
				"root"); 
		}catch(Exception e) {
			System.out.println("Cannot connect");
		}
		return connection;
	
	}
}
