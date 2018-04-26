package GUI;

import Database.CustomerDB;
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

public class CustomerForgotPassword {

	public void start(Stage primaryStage) {
		primaryStage.setTitle("WrightFlights ARS Main Menu");
		
		Label LUsername= new Label("Username");
		TextField username= new TextField();
		Label LSecurityQ= new Label("Security Answer:"+CustomerDB.getUserSecurityA(username.getText()));
		Label LSecurityA= new Label("Security Question Answer");
		PasswordField SecurityA= new PasswordField();
		
		Button enter = new Button("Enter");
		
		GridPane grid= new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20,20,20,20));
		
		grid.add(LUsername, 0, 0);
		grid.add(username, 1, 0);
		grid.add(LPassword, 0, 1);
		grid.add(password, 1, 1);
		grid.add(login, 0, 3);
		grid.add(register, 2, 3);
		grid.add(loginAdmin, 1, 3);
		
		grid.setAlignment(Pos.CENTER);
		username.setAlignment(Pos.BOTTOM_RIGHT);
		password.setAlignment(Pos.BOTTOM_LEFT);
		
		GridPane.setHalignment(login, HPos.LEFT);
		GridPane.setHalignment(loginAdmin, HPos.CENTER);
		GridPane.setHalignment(register, HPos.RIGHT);
		
		Scene scene=new Scene(grid, 400, 200);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		register.setOnAction(e->{
			
			try {
			Register user= new Register();
			user.start(new Stage());
		}finally{
			primaryStage.close();
		}
			
		});
	}
}
