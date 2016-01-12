import java.util.ArrayList;

public class Transaction {
	
	public static void book(Table<Flight> fTable, Table<Seat> sTable, Table<Passenger> pTable, Table<Reservation> rTable){
		
		// temp table for free seats
    	Table<Seat> freeSeats = new Table<Seat>();
			
    		int randomPassenger = (int) (Math.random()*pTable.size());										// choosing random passenger [index] from passengers table
    		int randomFlight = (int) (Math.random()*fTable.size());											// choosing random flight [index] from flights table
    		
    	    for(int f = 0; f < sTable.size(); f++){															// check for all seats in sTable
    	    	if((sTable.get(f).flightId() == randomFlight+1) && (!sTable.get(f).isBooked())){			// if seat belongs to chosen flight and is not booked then
    	    		freeSeats.add(sTable.get(f));															// add seats to the freeSeats list
    	    	}
    	    }
    	    
    	    if (freeSeats.size() > 0){																		// if there is free seats then
    	    	int randomFreeSeat = (int) (Math.random()*freeSeats.size());								// choose random seat from free seats list
    	    	if(freeSeats.size() == 1){																	// if there is only one free seat
    	    		randomFreeSeat = 0;																		// then take that seat
    	    	}
    	    	
    			Reservation res = new Reservation(pTable.get(randomPassenger), freeSeats.get(randomFreeSeat));	// create reservation

    	    	if (rTable.isEmpty()){ 																		// if reservations table is empty
    	    			freeSeats.get(randomFreeSeat).bookSeat();
    	    			rTable.add(res);																	// add reservation to reservation table
    	    	} else { 																					// if reservations table is NOT empty and
	    				if( exists(res, rTable) ){															// if seat is booked or seat exists in rTable
	    					//continue;																		// exit this loop
	    				} else {
	    	    			freeSeats.get(randomFreeSeat).bookSeat();										// else book that seat
	    	    			rTable.add(res);																// add to reservation table
	    				}
	    		  }
    	    }
		
	}

	// method for booking all seats
	public static void bookAllSeats(Table<Flight> fTable, Table<Seat> sTable, Table<Passenger> pTable, Table<Reservation> rTable){
		
	do {

	    // temp table for free seats
    	Table<Seat> freeSeats = new Table<Seat>();
			
    		int randomPassenger = (int) (Math.random()*pTable.size());										// choosing random passenger [index] from passengers table
    		int randomFlight = (int) (Math.random()*fTable.size());											// choosing random flight [index] from flights table
    		
    	    for(int f = 0; f < sTable.size(); f++){															// check for all seats in sTable
    	    	if((sTable.get(f).flightId() == randomFlight+1) && (!sTable.get(f).isBooked())){			// if seat belongs to chosen flight and is not booked then
    	    		freeSeats.add(sTable.get(f));															// add seats to the freeSeats list
    	    	}
    	    }
    	    
    	    if (freeSeats.size() > 0){																		// if there is free seats then
    	    	int randomFreeSeat = (int) (Math.random()*freeSeats.size());								// choose random seat from free seats list
    	    	if(freeSeats.size() == 1){																	// if there is only one free seat
    	    		randomFreeSeat = 0;																		// then take that seat
    	    	}
    	    	
    			Reservation res = new Reservation(pTable.get(randomPassenger), freeSeats.get(randomFreeSeat));	// create reservation

    	    	if (rTable.isEmpty()){ 																		// if reservations table is empty
    	    			freeSeats.get(randomFreeSeat).bookSeat();
    	    			rTable.add(res);																	// add reservation to reservation table
    	    	} else { 																					// if reservations table is NOT empty and
	    				if( exists(res, rTable) ){															// if seat is booked or seat exists in rTable
	    					continue;																		// exit this loop
	    				} else {
	    	    			freeSeats.get(randomFreeSeat).bookSeat();										// else book that seat
	    	    			rTable.add(res);																// add to reservation table
	    				}
	    		  }
    	    }
		}
		while( !(sTable.size() == rTable.size()) );															// keep booking until reservations table size is equal to seats table size
	}
	
	// method for booking all seats
	public static void bookAllSeatsWithComments(Table<Flight> fTable, Table<Seat> sTable, Table<Passenger> pTable, Table<Reservation> rTable){
		
	do {

	    // temp table for free seats
    	Table<Seat> freeSeats = new Table<Seat>();
			
    		int randomPassenger = (int) (Math.random()*pTable.size());										// choosing random passenger [index] from passengers table
    		int randomFlight = (int) (Math.random()*fTable.size());											// choosing random flight [index] from flights table
    		
    	    for(int f = 0; f < sTable.size(); f++){															// check for all seats in sTable
    	    	if((sTable.get(f).flightId() == randomFlight+1) && (!sTable.get(f).isBooked())){			// if seat belongs to chosen flight and is not booked then
    	    		freeSeats.add(sTable.get(f));															// add seats to the freeSeats list
    	    	}
    	    }
    	    
    	    if (freeSeats.size() > 0){																		// if there is free seats then
    	    	int randomFreeSeat = (int) (Math.random()*freeSeats.size());								// choose random seat from free seats list
    	    	if(freeSeats.size() == 1){																	// if there is only one free seat
    	    		randomFreeSeat = 0;																		// then take that seat
    	    	}
    	    	
    			Reservation res = new Reservation(pTable.get(randomPassenger), freeSeats.get(randomFreeSeat));	// create reservation

    	    	System.out.println("Passenger " + pTable.get(randomPassenger).passengerName() + " is trying to book a seat to " + freeSeats.get(randomFreeSeat).fDestination());

    	    	if (rTable.isEmpty()){ 																		// if reservations table is empty
    	    			System.out.println(pTable.get(randomPassenger).passengerName() + " picked seat ID number " + freeSeats.get(randomFreeSeat).seatId());
    	    			freeSeats.get(randomFreeSeat).bookSeat();
    	    			rTable.add(res);																	// add reservation to reservation table
    	    			System.out.println("Passenger "+ pTable.get(randomPassenger).passengerName() +" has booked a seat number "+ freeSeats.get(randomFreeSeat).seatId() +" to " + fTable.get(randomFlight).flightDestination());
    	    	} else { 																					// if reservations table is NOT empty
	    				if( exists(res, rTable) ){															// if seat booked or seat exists in rTable
	    					System.out.println("Already reserved => Searching new seat!");					// print message
	    					continue;																		// and exit this loop
	    				} else {
	    	    			System.out.println(pTable.get(randomPassenger).passengerName() + " picked seat ID number " + freeSeats.get(randomFreeSeat).seatId());
	    	    			freeSeats.get(randomFreeSeat).bookSeat();										// else book that seat
	    	    			rTable.add(res);																// add to reservation table
	    	    			System.out.println("Passenger "+ pTable.get(randomPassenger).passengerName() +" has booked a seat number "+ freeSeats.get(randomFreeSeat).seatId() +" to " + fTable.get(randomFlight).flightDestination());
	    				}
	    		  }
    	    } else {																						// else if there is no free seats for that flight																			
    	    	System.out.println("There are no free seats available for this flight!");					// print message
    	    }
		}
		while( !(sTable.size() == rTable.size()) );															// keep booking until reservations table size is equal to seats table size
			System.out.println("All seats are booked!!!");
	}
	
	
	// check if reservation exists in table
	private static boolean exists(Reservation res, Table<Reservation> rTable){
		for(int r = 0; r < rTable.size(); r++){
			if( (Transaction.sameDestination(rTable.get(r), res)) || (rTable.get(r).seatId() == res.seatId()) ){
				return true;
			}
		}
			return false;
	}
	
	// return total sum of all reservations
	public static int totalReservations(ArrayList<Reservation> rTable) {
		return rTable.size();
	}
	
	// show reservations for specific passenger
	public static void myReservations(String p, ArrayList<Reservation> rTable) {
		System.out.println("Reservations of passenger " + p + ":" );
		for(int i = 0; i < rTable.size(); i++){
			if(rTable.get(i).seatOwner() == p){
				System.out.println(rTable.get(i));
			}
		}
	}
	
	// check if two reservations have same destination
	private static boolean sameDestination(Reservation a, Reservation b){
		if( (a.seatOwner() == b.seatOwner() ) && ( a.seatDestination() == b.seatDestination() ) ){
			return true;
		}else{
			return false;
		}
	}
	
}

