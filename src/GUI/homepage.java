package GUI;

import BusinessLogic.User;
import GUI.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessLogic.Admin;
import BusinessLogic.Login;

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

public class homepage extends Application  {
@Override
public void start(Stage primaryStage) {
	primaryStage.setTitle("Log in");
	
	
	
	Label LUsername= new Label("Username");
	TextField username= new TextField();
	Label LPassword= new Label("Password");
	PasswordField password= new PasswordField();
	
	Button login = new Button("Login");
	Button register = new Button("Register");
	
	GridPane grid= new GridPane();
	grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(20,20,20,20));
	
	grid.add(LUsername, 0, 0);
	grid.add(username, 1, 0);
	grid.add(LPassword, 0, 1);
	grid.add(password, 1, 1);
	grid.add(login, 0, 3);
	grid.add(register, 1, 3);
	
	grid.setAlignment(Pos.CENTER);
	username.setAlignment(Pos.BOTTOM_RIGHT);
	password.setAlignment(Pos.BOTTOM_LEFT);
	
	GridPane.setHalignment(login, HPos.LEFT);
	GridPane.setHalignment(register, HPos.RIGHT);
	
	Scene scene=new Scene(grid, 300, 150);
	primaryStage.setTitle("Login");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	//register.setOnAction(e->{});
	
	login.setOnAction(a-> {
		
		try {
			
			Connection connection = getConnection();
			
			System.out.println("1");
			
			
			String pw= password.getText().trim();
			String usr= username.getText().trim();
		

					String str= "SELECT CPassword FROM Customer WHERE CUsername ='"+usr+"'";
					
					// Prepare Statement
					PreparedStatement statement = connection.prepareStatement(str);

					// Execute Statement
					ResultSet resultSet = statement.executeQuery();
				
					while(resultSet.next()) {
					
						if(resultSet.getString(1).equals(pw)) 
						
							System.out.println("Valid pw");
							else
							System.out.println("Inalid pw");}
					 connection.close();
					} catch (Exception ex) {

				} 
		
		});
	
	
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
	public static void main(String[] args) {
		launch(args);
	}
}
