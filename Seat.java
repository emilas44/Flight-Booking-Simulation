
public class Seat {

	private static int seatIdCounter = 0;
	private int seat_id;
	private int flight_id;
	private boolean isBooked;
	private String fDestination;
	
	{
		seatIdCounter++;								// increment seat_id by 1
		seat_id = seatIdCounter;						// set seat_id equal to seatIdCounter;
	}
	// constructor
	public Seat(int fID, boolean isbooked, String destination){
		this.flight_id = fID;
		this.isBooked = isbooked;
		this.fDestination = destination;
	}
	
	// get seat ID
	public int seatId(){					
		return seat_id;
	}
	
	// get flight ID
	public int flightId(){					
		return flight_id;
	}
	
	//get flight destination
	public String fDestination(){
		return fDestination;
	}
	
	// check if seat is booked
	public boolean isBooked() {
		return isBooked;
	}
	
	// book the seat
	public void bookSeat() {
		if(!this.isBooked){
			this.isBooked = true;
		}else {
			System.out.println("Seat "+ this.seat_id +" is already booked!!!");
		}

	}	
	
	///////////// Override ////////// format the printout of this object
	@Override
	public String toString(){
		return String.format("%2s\t|%4s\t|%12s\t|%8s    |", this.seat_id, this.flight_id, this.fDestination, this.isBooked);	
	}
	
}
