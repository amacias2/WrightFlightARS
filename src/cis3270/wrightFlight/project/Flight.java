package cis3270.wrightFlight.project;

public class Flight {
	private int flightID;
	private String flightNum;
	private StringBuilder departureDate;
	private StringBuilder departureTime;
	private StringBuilder arrivalTime;
	private StringBuilder flightDuration;
	private String to;
	private String from;
	private String airlineName;
	private int capacity;
	private int numBooked;
	private double flight_price; 
	
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
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
	
	public String toString() {
		return  flightID +"";
	}
	
	public boolean flightCheck(int flightID) {
		if(flightID == this.getFlightID()) {
			return true;
		}
		
		return false;
		
	}
	public double getFlight_price() {
		return flight_price;
	}
	public void setFlight_price(double flight_price) {
		this.flight_price = flight_price;
	}
	
}
