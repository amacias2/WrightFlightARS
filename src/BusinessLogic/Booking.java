package BusinessLogic;
import java.util.Date;
import BusinessLogic.Flight;
import javafx.application.Application;

public class Booking extends Flight {
	
	private static int confirmationNum;
	private long timeBooked;
	private String status;
	private String seatAssignment;
	private String bookedPrice;
	private String ssn;
	
	
	

	
	
	
	public Booking(String flightNum, String departureDate, String departureTime, String arrivalTime,
			String flightDuration, String to, String from, String airlineName, int capacity, int numBooked,
			String destinationAirport, String flight_price, String boardingTime) {
		super(flightNum, departureDate, departureTime, arrivalTime, flightDuration, to, from, airlineName, capacity, numBooked,
				destinationAirport, flight_price, boardingTime);
		this.confirmationNum=confirmationNum++;
		this.timeBooked= new Date().getTime();
		this.status= "Booked";
		this.bookedPrice=flight_price;
		this.ssn= ssn;
	}
	public int getConfirmationNum() {
		return confirmationNum;
	}
	public void setConfirmationNum(int confirmationNum) {
		this.confirmationNum = confirmationNum;
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
	public String getBookedPrice() {
		return bookedPrice;
	}
	public void setBookedPrice(String bookedPrice) {
		this.bookedPrice = bookedPrice;
	}
	
	
	
}
