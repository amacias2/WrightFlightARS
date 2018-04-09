package cis3270.wrightFlight.project;

import java.util.Date;

public class Booking {
	
	private static int confirmationNum;
	private long timeBooked;
	private String status;
	private String seatAssignment;
	private double bookedPrice;
	
	public Booking(Flight flightID) {
		this.confirmationNum=confirmationNum++;
		this.timeBooked= new Date().getTime();
		this.status= "Booked";
		this.bookedPrice= flightID.getFlight_price();
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
	public double getBookedPrice() {
		return bookedPrice;
	}
	public void setBookedPrice(double bookedPrice) {
		this.bookedPrice = bookedPrice;
	}
	
	
	
}
