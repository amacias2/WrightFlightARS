package ValueObject;
import BusinessLogic.Admin;
import BusinessLogic.User;
public class VO implements register {
//test to push 
	 long timeBooked;
	 String status;
	 String seatAssignment;
	 double bookedPrice;
	 String ssn;
	 private String firstName;
	 private String midName;
	 String lastName;
	 String username;
	 String password;
	 String street;
	 String state;
	 String country;
	 String email;
	 String securityQ;
	 String securityA;
	 String flightNum;
	 StringBuilder departureDate=new StringBuilder();
	 StringBuilder departureTime=new StringBuilder();
	 StringBuilder arrivalTime=new StringBuilder();
	 StringBuilder flightDuration=new StringBuilder();
	 StringBuilder boardingTime= new StringBuilder();
	 String to;
	 String from;
	 String airlineName;
	 
	 
	 public StringBuilder getBoardingTime() {
		return boardingTime;
	}
	public void setBoardingTime(StringBuilder boardingTime) {
		this.boardingTime = boardingTime;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	String zipCode;
	 String flightID;
	 int capacity;
	 int numBooked;
	 double flight_price;
	 String adminAns=null;
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
	public long getTimeBooked() {
		return timeBooked;
	}
	public void setTimeBooked(long timeBooked) {
		this.timeBooked = timeBooked;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeatAssignment() {
		return seatAssignment;
	}
	public void setSeatAssignment(String seatAssignment) {
		this.seatAssignment = seatAssignment;
	}
	public double getBookedPrice() {
		return bookedPrice;
	}
	public void setBookedPrice(double bookedPrice) {
		this.bookedPrice = bookedPrice;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public StringBuilder getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(StringBuilder departureDate) {
		this.departureDate = departureDate;
	}
	public StringBuilder getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(StringBuilder departureTime) {
		this.departureTime = departureTime;
	}
	public StringBuilder getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(StringBuilder arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public StringBuilder getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(StringBuilder flightDuration) {
		this.flightDuration = flightDuration;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNumBooked() {
		return numBooked;
	}
	public void setNumBooked(int numBooked) {
		this.numBooked = numBooked;
	}
	public double getFlight_price() {
		return flight_price;
	}
	public void setFlight_price(double flight_price) {
		this.flight_price = flight_price;
	}
	public String getAdminAns() {
		return adminAns;
	}
	public void setAdminAns(String adminAns) {
		this.adminAns = adminAns;
	} 
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFlightID() {
	
		return flightID;
	}
	
	public void registerVO( VO a) {
		//Check for valid name
		try {
		if(!a.getFirstName().matches("\\w*")|| !a.getLastName().matches("\\w*")||!a.getMidName().matches("\\w*"))
			throw new Exception("Please enter a valid name.");
		}catch(Exception e) {
			//send to gui dialog box that prints exception message
		}
		//check for valid email
		try {
		if(!a.email.matches("\\S+?\\w*?@\\D*.\\D{3}"))
			throw new Exception("Please enter a valid email.");
		}catch(Exception e) {
			//send to gui dialog box that prints exception message
		}
		//check for valid ssn
		try {
			if(!a.email.matches("\\d{3}\\-?\\d{2}\\-?\\d{4}"))
				throw new Exception("Please enter a valid ssn.");
			}catch(Exception e) {
				//send to gui dialog box that prints exception message
			}
		try {
		if(a.getAdminAns()==Admin.getAdminPW()) {
			Admin.registerAdmin(a);
			return;
		}else if(a.getAdminAns() != null ) {
			throw new Exception("Admin password is invalid.");
		}}
		catch(Exception e) {
			//send to gui dialog box that prints exception message	
			}
		
		User.registerUser(a);
	
	}
	
	public void authentication(VO a) {
		
	}
	
	
	
	
}
