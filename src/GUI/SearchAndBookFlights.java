package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BusinessLogic.Booking;
import BusinessLogic.Customer;
import BusinessLogic.Flight;
import Database.FlightDB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class SearchAndBookFlights extends Application {

public void start(Stage primaryStage){
	
	Text toLabel = new Text("To City: ");
	TextField toText = new TextField("");

	ChoiceBox ToStateBox = new ChoiceBox();
	ToStateBox.getItems().addAll("","AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");

	
	Text fromLabel = new Text("From City:");
	TextField fromText = new TextField("");
	
	ChoiceBox FromStateBox = new ChoiceBox();
	FromStateBox.getItems().addAll("","AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY");

	Text dDateLabel = new Text("Departure Month:");
	ChoiceBox MonthBox = new ChoiceBox();
	MonthBox.getItems().addAll("","January", "Febuary","March","April","May","June","July","August","September","October","December");

	Text DayLabel = new Text("Departure Day:");
	TextField dayText = new TextField("");
	
	Text dYearLabel = new Text("Departure Year:");
	ChoiceBox YearBox = new ChoiceBox();
	YearBox.getItems().addAll("","2018", "2019");
	
	
	Text dTimeLabel = new Text("Departure Time:");
	TextField dTimeText = new TextField("");
	ChoiceBox TimeBox = new ChoiceBox();
	TimeBox.getItems().addAll("","AM", "PM");
	
	primaryStage.setTitle("Search Flights");
	GridPane grid1= new GridPane();
	grid1.setHgap(5);
	grid1.setVgap(5);
	grid1.setPadding(new Insets(20,20,20,20));
	grid1.setAlignment(Pos.TOP_LEFT);
	grid1.add(toLabel, 0, 0);
	grid1.add(toText, 1, 0);
	grid1.add(ToStateBox,2,0);
	grid1.add(fromLabel, 0, 1);
	grid1.add(fromText, 1, 1);
	grid1.add(FromStateBox, 2,1);
	grid1.add(dDateLabel,0,2);
	grid1.add(MonthBox,1,2);
	grid1.add(DayLabel,0,3);
	grid1.add(dayText,1,3);
	grid1.add(dYearLabel,0,4);
	grid1.add(YearBox,1,4);
	grid1.add(dTimeLabel,0,5);
	grid1.add(dTimeText,1,5);
	grid1.add(TimeBox,2,5);
	
	
	Button searchB=new Button("Search Flights");
	grid1.add(searchB, 2, 6);
	searchB.setOnAction(s->{
		try {
		
			if(!dTimeText.equals("")&& !dTimeText.getText().matches("\\d{2}:\\d{2}")) {
			AlertMessage.display("Incorrect Time Format", "Please enter time as HH:MM and try again");
			}else {
				FlightDB.searchflight(toText.getText(), (String)ToStateBox.getValue() , fromText.getText(), (String)FromStateBox.getValue(), (String)MonthBox.getValue(), dayText.getText(), (String)YearBox.getValue(), dTimeText.getText(), (String)TimeBox.getValue());
			}
		
	} catch(Exception a){
		
	}});
	
	
	//Button userView= new Button("Main page");
	//userView.setOnAction(a->{
		//main user page
		//add try and catch
	//});
	
	
	//Button logout= new Button("Log Out");
	//logout.setOnAction(b->{
	//	homepage hpage=new homepage();
		//try {
			//hpage.start(primaryStage);
		//}catch(Exception e){
		//	e.printStackTrace();
		//}
	//});
	
	
	Scene scene= new Scene(grid1);
	primaryStage.setScene(scene);
	primaryStage.show();
}

	
}
