package cis3270.wrightFlight.project;

import cis3270.wrightFlight.project.Flight;

public class User {


	private String firstName;
	private String midName;
	private String lastName;
	private String username;
	private String password;
	private String street;
	private String state;
	private String country;
	private String email;
	private String securityQ;
	private String securityA;
	private String ssn;
	
	//constructor to fill info for user
	public User(String firstName, String lastName, String username, String password, String street, String state,
			String country, String email, String securityQ, String securityA, String ssn, String midName) {
		this.firstName = firstName;
		this.midName=midName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.street = street;
		this.state = state;
		this.country = country;
		this.email = email;
		this.securityQ = securityQ;
		this.securityA = securityA;
		this.ssn = ssn;
	}
	
	// getters and setters for all attributes
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSecurityQ() {
		return securityQ;
	}
	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}
	public String getSecurityA() {
		return securityA;
	}
	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	//returns true if username and password passed is same as username and password of user
	public boolean login(String username, String password) {
		if(this.username.equals(username)&& this.password.equals(password)) {
			return true;
		}
			return false;
			
		}
	
	//displays password if string passed equals security answer
	public void resetLogin(String secuirtyA) {
		
		if(this.securityA.equals(secuirtyA)) 
			System.out.println(this.getPassword());
	}
	
	// override to string to display customer info 
	@Override
	public String toString() {
		return ("Name:"+ this.getFirstName() +" "+ this.getMidName() +" "+ this.getLastName() + "\n Username:" + this.getUsername());
	}
	
	public void searchFlight() {
		
	}
	
	public Flight selectFlight() {
		return new Flight();
	}
	public void createBooking() {
		new Booking( this.selectFlight(), this.getSsn() );
	}
	
	
}
