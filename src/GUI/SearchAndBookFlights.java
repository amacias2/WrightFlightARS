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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class SearchAndBookFlights extends Application {
	public static void main(String[] args) {
		launch(args);
	}

@Override
public void start(Stage primaryStage) throws Exception{
	primaryStage.setTitle("Search Flights");
	GridPane grid1= new GridPane();
	grid1.setHgap(5);
	grid1.setVgap(5);
	grid1.setPadding(new Insets(20,20,20,20));
	
	Text toLabel = new Text("To: ");
	TextField toText = new TextField();

	Text fromLabel = new Text("From City:");
	TextField fromText = new TextField();
	
	ChoiceBox StateBox = new ChoiceBox();
	StateBox.getItems().addAll("AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");

	Text dDateLabel = new Text("Departure Month:");
	ChoiceBox MonthBox = new ChoiceBox();
	MonthBox.getItems().addAll("January", "Febuary","March","April","May","June","July","August","September","October","December");

	Text DayLabel = new Text("Departure Day:");
	TextField dayText = new TextField();
	
	Text dYearLabel = new Text("Departure Year:");
	ChoiceBox YearBox = new ChoiceBox();
	YearBox.getItems().addAll("2018", "2019");
	
	
	Text dTimeLabel = new Text("Departure Time:");
	TextField dTimeText = new TextField();
	ChoiceBox TimeBox = new ChoiceBox();
	YearBox.getItems().addAll("AM", "PM");

	grid1.add(toLabel, 0, 0);
	grid1.add(toText, 1, 0);
	grid1.add(fromLabel, 0, 1);
	grid1.add(fromText, 1, 1);
	grid1.add(StateBox, 2,1);
	grid1.add(dDateLabel,0,2);
	grid1.add(MonthBox,1,2);
	grid1.add(DayLabel,0,3);
	grid1.add(dayText,1,3);
	grid1.add(dYearLabel,0,4);
	grid1.add(YearBox,1,4);
	grid1.add(dTimeLabel,0,5);
	grid1.add(dTimeText,1,5);
	grid1.add(TimeBox,2,5);
	
	
	Button userView= new Button("Main page");
	userView.setOnAction(a->{
		//main user page
		//add try and catch
	});
	
	
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
	
	
	table.setLayoutX(20);
	table.setLayoutY(100);
	table.setMinWidth(1000);
	table.getColumns().addAll(column1,column2, column3, column4, column5, column6, column7, column8, column9,column10,column11,column12,column13);
	anchor.getChildren().addAll(dropdown, username, search, searchB, table, userView, logout);
	Scene scene= new Scene(anchor,1300,700);
	
	primaryStage.setScene(scene);
	primaryStage.show();
}

	// test
	public String getChoice(ChoiceBox<String> dropdown) {
		String dbSearch = "";
		String choice = dropdown.getValue();
		if (choice.equals("To")) {
			dbSearch = "fTo";
		} else if (choice.equals("From")) {
			dbSearch = "fFrom";
		} else if (choice.equals("Date")) {
			dbSearch = "fDate";
		} else if (choice.equals("Time")) {
			dbSearch = "DepartureTime";
		} else if (choice.equals("Airline")) {
			dbSearch = "AirlineName";
		}
		return dbSearch;
	}

	/*
	 * public int conflictCheck(StringBuilder DepartureTime, StringBuilder
	 * ArrivalTime,) {
	 * 
	 * }
	 */
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
