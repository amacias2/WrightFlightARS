package cis3270.wrightFlight.project;

public class Flight {
	private int flightID;
	private int flightNum;
	private StringBuilder departureDate;
	private StringBuilder departureTime;
	private StringBuilder arrivalTime;
	private StringBuilder flightTime;
	private String to;
	private String from;
	private String airlineName;
	private int capacity;
	private int numBooked;
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public int getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(int flightNum) {
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
	public StringBuilder getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(StringBuilder flightTime) {
		this.flightTime = flightTime;
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
	
}