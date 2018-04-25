package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register extends Application {
	@Override
	public void start(Stage Registrationstage) {
		Text fnameLabel=new Text("First Name: ");
		TextField fnameText = new TextField();
		
		Text mnameLabel=new Text("Middle Name:");
		TextField mnameText= new TextField();
		
		Text lnameLabel=new Text("Last Name:");
		TextField lnameText= new TextField();
		
		Text addressLabel=new Text("Address:");
		TextField addressText= new TextField();
		
		Text zipLabel=new Text("Zipcode:");
		TextField zipText= new TextField();
		
		Text stateLabel=new Text("State:");
		TextField stateText= new TextField();
		
		Text usernameLabel=new Text("Username:");
		TextField usernameText= new TextField();
		
		Text passwordLabel=new Text("Password:");
		TextField passwordText= new TextField();
		
		Text emailLabel=new Text("Email:");
		TextField emailText= new TextField();
		
		Text ssnLabel=new Text("SSN:");
		TextField ssnText= new TextField();
		
		Text securityQLable= new Text("Security question");
		ChoiceBox securityQBox = new ChoiceBox();
		securityQBox.getItems().addAll("What is my favorite color?","What is my favorite pizza?","What is my childhood pet's name?");
		
		Text securityALabel=new Text("Security answer:");
		TextField securityAText= new TextField();
		
		Button buttonRegister = new Button("Register");
		
        GridPane gridPane = new GridPane();     
	      gridPane.setMinSize(500, 500);   
	      gridPane.setPadding(new Insets(10, 10, 10, 10));  
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);        
	      gridPane.setAlignment(Pos.CENTER); 

	      gridPane.add(fnameLabel, 0, 0); 
	      gridPane.add(fnameText, 1, 0); 
	       
	      gridPane.add(mnameLabel, 0, 1);       
	      gridPane.add(mnameText, 1, 1); 
	      
	      gridPane.add(lnameLabel, 0, 2);       
	      gridPane.add(lnameText, 1, 2); 
	      
	      gridPane.add(addressLabel, 0, 3);       
	      gridPane.add(addressText, 1, 3); 
	      
	      gridPane.add(zipLabel, 0, 4);       
	      gridPane.add(zipText, 1, 4); 
	      
	      gridPane.add(stateLabel, 0, 5);       
	      gridPane.add(stateText, 1, 5); 
	      
	      gridPane.add(usernameLabel, 0, 6);       
	      gridPane.add(usernameText, 1, 6); 
	      
	      gridPane.add(passwordLabel, 0, 7);       
	      gridPane.add(passwordText, 1, 7);
	      
	      gridPane.add(emailLabel, 0, 8);       
	      gridPane.add(emailText, 1, 8); 
	      
	      gridPane.add(ssnLabel, 0, 9);       
	      gridPane.add(ssnText, 1, 9);      
	       
	      gridPane.add(securityQLable, 2, 0); 
	      gridPane.add(securityQBox, 3, 0);    
	      
	      gridPane.add(securityALabel, 2, 1);       
	      gridPane.add(securityAText, 3, 1);
	      
	      gridPane.add(buttonRegister, 2, 2);
	      gridPane.setStyle("-fx-background-color: YELLOW;");
	      Scene scene=new Scene(gridPane);
	      Registrationstage.setTitle("Registration Form");
	      Registrationstage.setScene(scene);
	      Registrationstage.show();
	      
	      buttonRegister.setOnAction(a -> {
	    	  //what happens when button register is clicked
	    	  //test below
	    	  System.out.println("Welcome");
	      });
	      
	}
	public static void main(String []args) {
		launch(args);
	}
}
