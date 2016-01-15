
public class Main {

	public static void main(String[] args){
		
		// tables
        Table<Flight> fTable = new Table<Flight>();
        Table<Seat> sTable = new Table<Seat>();
        Table<Passenger> pTable = new Table<Passenger>();
        Table<Reservation> rTable = new Table<Reservation>();
        
        sTable.clear();
        rTable.clear();
        
        // input number of flights seats and passengers
        System.out.print("Input number of flights (1 - 20): ");
        int nFlights = SavitchIn.readInt();
        if( nFlights < 1 || nFlights > 20 ){
        	System.out.println("Wrong number of flights!\nProgram has stopped!");
        	System.exit(1);
        }
        System.out.print("How many seats for every flight (1 - 250): ");
        int nSeats = SavitchIn.readInt();
        if( nSeats < 1 || nSeats > 250 ){
        	System.out.println("Wrong number of seats!\nProgram has stopped!");
        	System.exit(1);
        }
        System.out.print("Input number of passengers (1 - 250): ");
        int nPassengers = SavitchIn.readInt();
        if( nPassengers < 1 || nPassengers > 250 ){
        	System.out.println("Wrong number of passengers!\nProgram has stopped!");
        	System.exit(1);
        }

        // insert all Flight objects into fTable and seats to sTable
        Table.populateTableFS(fTable, sTable, nFlights, nSeats);
       
        // insert all Passenger objects into pTable
        Table.populateTableP(pTable, nPassengers);
        
        // print all tables
        Table.showTable(fTable);
        System.out.println();
        Table.showTable(sTable);
        System.out.println();
        Table.showTable(pTable);



	    
        
        
        System.out.println("\n::::::::::::TESTING OUTPUT:::::::::::::::::\n");
       
        double start = System.currentTimeMillis();
        
        //Transaction.bookAllSeatsWithComments(fTable, sTable, pTable, rTable);
        for(int i=0;i<100;i++){
        Transaction.book(fTable, sTable, pTable, rTable);
        }

        
        double end = System.currentTimeMillis();
        
        System.out.println("\n::::::::::::no comments:::::::::::::::::\n");
       
        System.out.println("Time needed to book all seats\t" + (end-start)/1000 + " seconds");
        
        System.out.println("Total number of reservations: " + Transaction.totalReservations(rTable));

        Transaction.myReservations("Abbie", rTable);
        
        Table.showTable(rTable);
        System.out.println();
        Table.showTable(sTable);
        // test
 
		
	}
}
