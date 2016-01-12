
public class Reservation {

	private Passenger passenger;
	private Seat seat;
	
	// constructor
	public Reservation(Passenger passenger, Seat seat) {
		this.passenger = passenger;
		this.seat = seat;
	}
	// get passenger name who reserved the seat
	public String seatOwner() {
		return passenger.passengerName();
	}
	
	// get passenger id who reserved the seat
	public int seatOwnerId() {
		return passenger.passenger_id();
	}
	
	// get reserved seat ID
	public int seatId() {
		return seat.seatId();
	}
	// get reserved seat destination
	public String seatDestination() {
		return seat.fDestination();
	}
	
	///////////// Override ////////// format the printout of this object
	@Override
	public String toString() {
		return String.format("  %-8s\t|\t%4s\t|  --> %-11s|", passenger.passengerName(), seat.seatId(), seat.fDestination());
	}
	
	
	
}
