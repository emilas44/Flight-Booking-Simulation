
public class Passenger {

	private static int passengerIdCounter = 0;
	private int passenger_id;
	private String pName;
	
	{
		passengerIdCounter++;								// increment flight_id by 1
		passenger_id = passengerIdCounter;						// set seat_id equal to seatIdCounter;
	}
	
	// constructor
	public Passenger(String pname){
		this.pName = pname;		
	}
	
	// get passenger ID
	public int passenger_id() {
		return passenger_id;
	}
	
	// get pName
	public String passengerName() {
		return pName;
	}


	///////////// Override ////////// format the printout of this object
	@Override
	public String toString(){
		return String.format(" %s\t|    %s\t|", passenger_id, pName);	
	}
}
