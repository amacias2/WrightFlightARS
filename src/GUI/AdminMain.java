package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminMain extends Application{
	
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("Welcome Admin");
	
	Label Lflightid= new Label("Flight ID:");
	TextField flightid=new TextField();
	
	
	Button addFlight=new Button("Add a Flight");
	Button removeFlight=new Button("Remove a Flight");
	Button updateFlight= new Button("Update a Flight");
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	grid.add(addFlight, 0, 0);
	grid.add(removeFlight, 0, 1);
	grid.add(updateFlight, 0, 2);
	
	grid.setAlignment(Pos.CENTER);
	
	Scene scene=new Scene(grid, 600, 300);
	primaryStage.setTitle("Admin");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	addFlight.setOnAction(a->{
		try {
			addFlight flight= new addFlight();
			flight.start(new Stage());
		}finally{
			primaryStage.close();
		}
	});
}
}
