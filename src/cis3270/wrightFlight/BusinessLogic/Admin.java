package cis3270.wrightFlight.project;
import  cis3270.wrightFlight.ValueObject;
import java.util.Scanner;

public class Admin extends User {

	public Admin(String firstName, String lastName, String username, String password, String street, String state,
			String country, String email, String securityQ, String securityA, String ssn) {
		super(firstName, lastName, username, password, street, state, country, email, securityQ, securityA, ssn, ssn);

	}

	public void createFlight(VO a) {
		Scanner input = new Scanner(System.in);

		new Flight(a.firstName, a.lastName, a.username, a.password, a.street, a.state, a.country, a.email, a.securityQ, a.securityA, a.ssn);

	}
	
	

}
