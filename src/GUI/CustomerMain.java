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

public class CustomerMain extends Application{
	public static void main(String [] args) {
		launch(args);
	}
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("Welcome User");
	
	Button searchFlights=new Button("Search Flights");
	Button viewBookedFlights= new Button("View Booked Flights");
	Button logout= new Button("Log out");
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	grid.add(searchFlights, 0, 0);
	grid.add(viewBookedFlights, 0, 1);
	grid.add(logout, 0, 2);
	
	grid.setAlignment(Pos.CENTER);
	grid.setStyle("-fx-background-color: LAVENDER;");
	
	Scene scene=new Scene(grid, 600, 300);
	primaryStage.setTitle("Welcome User");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	searchFlights.setOnAction(a->{
		try {
			SearchFlights sf=new SearchFlights();
			sf.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			primaryStage.close();
		}
	});
	logout.setOnAction(b->{
		try {
			homepage hp=new homepage();
			hp.start(new Stage());
		}finally {
			primaryStage.close();
		}
	});
	}

}
