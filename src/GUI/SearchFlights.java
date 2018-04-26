package GUI;


import java.sql.Connection;
import java.sql.DriverManager;

import BusinessLogic.Booking;
import BusinessLogic.Customer;
import BusinessLogic.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class SearchFlights extends Application implements EventHandler<ActionEvent> {
	public static void main(String[]args) {
		launch(args);
	}

@Override
public void start(Stage primaryStage) throws Exception{
	primaryStage.setTitle("Search Flights");
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
	
	try {
		Connection connection = getConnection();
	}
	
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
