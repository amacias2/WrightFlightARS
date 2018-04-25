package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class homepage extends Application{
	private TextField username=new TextField();
	private TextField password= new TextField();
	private Button login= new Button("Login");
	private Button register= new Button("Register");
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("Log in");
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	Label LUsername= new Label("Username");
	TextField username= new TextField();
	Label LPassword= new Label("Password");
	PasswordField password= new PasswordField();
	
	grid.add(LUsername, 0, 0);
	grid.add(username, 1, 0);
	grid.add(LPassword, 0, 1);
	grid.add(password, 1, 1);
	grid.add(login, 1, 3);
	grid.add(register, 1, 3);
	
	grid.setAlignment(Pos.CENTER);
	username.setAlignment(Pos.BOTTOM_RIGHT);
	password.setAlignment(Pos.BOTTOM_LEFT);
	
	GridPane.setHalignment(login, HPos.LEFT);
	GridPane.setHalignment(register, HPos.RIGHT);
	
	register.setOnAction(e ->{
		//what needs to happen if they click on register
		
	});
	
	login.setOnAction(a->{
		//what needs to happen if they click on login 2
	});
	
	Scene scene=new Scene(grid, 300, 150);
	primaryStage.setTitle("Login");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
public static void main(String[] args) {
	launch(args);
}
}
