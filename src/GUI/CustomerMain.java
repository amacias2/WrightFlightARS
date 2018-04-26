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
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	grid.setAlignment(Pos.CENTER);
	
	Scene scene=new Scene(grid, 600, 300);
	primaryStage.setTitle("Welcome User");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}
