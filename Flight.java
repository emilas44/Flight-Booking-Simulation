import java.util.Vector;

public class Flight {
	// variables initialization
	private static int flightIdCounter = 0;
	private int flight_id;
	private String fDestination;
	private int fCapacity;
	public Vector<Seat> seats = new Vector<Seat>();
	
	// this block of code runs always when we create a new object of this class
	{
		flightIdCounter++;									// increment flightIdCounter by 1
		flight_id = flightIdCounter;						// set flight_id equal to flightIdCounter so that the id value is preserved
	}
	
	// constructor
	public Flight(String fdestination, int capacity) {
		this.fDestination = fdestination;					// set Flight name (fdestination) = fdestination
		this.fCapacity = capacity;							// set flight capacity = fCapacity
		for (int i = 1; i < capacity+1; i++){
			Seat seat = new Seat(flight_id, false, fdestination);
			seats.add(seat);
		}
	}
	
	// get fDestination
	public String flightDestination() {
		return fDestination;
	}

	// flightID getter
	public int flightId(){						
		return flight_id;
	}
	
	// capacity getter
	public int getCapacity(){
		return fCapacity;
	}

	///////////// Override ////////// format the printout of this object
	@Override
	public String toString(){
		return String.format(" %s\t|  %s   \t|\t%s\t|", flight_id, fDestination, fCapacity);
	}


}