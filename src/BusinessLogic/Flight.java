package BusinessLogic;


public class Flight {
	private static String flightID;
	private String flightNum;
	private StringBuilder departureDate = new StringBuilder();
	private StringBuilder departureTime = new StringBuilder();
	private StringBuilder arrivalTime = new StringBuilder();
	private StringBuilder flightDuration = new StringBuilder();
	private String to;
	private String from;
	private String airlineName;
	private int capacity;
	private int numBooked;
	private String destinationAirport;
	private double flight_price;
	private StringBuilder boardingTime = new StringBuilder();

	public Flight(String flightNum, StringBuilder departureDate, StringBuilder departureTime, StringBuilder arrivalTime,
			StringBuilder flightDuration, String to, String from, String airlineName, int capacity, int numBooked,
			String destinationAirport, double flight_price, StringBuilder boardingTime) {
		super();
		this.flightNum = flightNum;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
		this.to = to;
		this.from = from;
		this.airlineName = airlineName;
		this.capacity = capacity;
		this.numBooked = numBooked;
		this.destinationAirport = destinationAirport;
		this.flight_price = flight_price;
		this.boardingTime = boardingTime;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public StringBuilder getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(StringBuilder boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
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
		System.out.println(flightID + "");
		return flightID + "";
	}

	public boolean flightCheck(String flightID) {
		if (flightID.equals(this.getFlightID())) {
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
