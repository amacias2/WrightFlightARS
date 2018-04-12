package cis3270.wrightFlight.project;

import java.util.Scanner;

public class Admin extends User {

	public Admin(String firstName, String lastName, String username, String password, String street, String state,
			String country, String email, String securityQ, String securityA, String ssn) {
		super(firstName, lastName, username, password, street, state, country, email, securityQ, securityA, ssn, ssn);

	}

	public void createFlight() {
		Scanner input = new Scanner(System.in);

		new Flight(input.next(), new StringBuilder(input.next()), new StringBuilder(input.next()),
				new StringBuilder(input.next()), new StringBuilder(input.next()), input.next(), input.next(),
				input.next(), input.nextInt(), input.nextInt(), input.nextDouble()).toString();

	}
	
	

}
