
import java.util.ArrayList;

public class Table<T> extends ArrayList<T>{

	private static final long serialVersionUID = 1L;
	
	// 20 different flight destinations
    private static String[] fNames = {"Amsterdam", "Berlin", "Budapest", "Dublin", "Frankfurt", "London", "Madrid", "Milano", "Muenchen", "New York", "Oslo", "Paris", "Rome", "Salzburg", "Stockholm", "Sydney", "Tokyo", "Wien", "Zagreb", "Zuerich"};
    
    // 250 different names
    private static String[] pNames = {"Abbie", "Adele", "Albert", "Alec", "Alexis", "Ali", "Alma", "Amy", "Angelia", "Arcelia", "Arlette", "Arline", "Arnita", "Arthur", "August", "Aurea", "Beau", "Bennett", "Bethanie", "Bob", "Boris", "Breana", "Buck", "Calvin", "Candy", "Carley", "Carlie", "Cecille", "Chan", "Cher", "Cherish", "Cherrie", "Cheryl", "China", "Christel", "Chris", "Chun", "Cleopatra", "Cristi", "Cythia", "Darcel", "Darlena", "Daysi", "Dean", "Debi", "Delfina", "Demetria", "Dessie", "Detra", "Dominga", "Domonique", "Dona", "Dong", "Dorothea", "Dot", "Doyle", "Dreama", "Earlene", "Earnestine", "Edmundo", "Elba", "Elfriede", "Eli", "Elicia", "Elida", "Elisabeth", "Elvera", "Emely", "Ernie", "Errol", "Esteban", "Fay", "Fabian", "Felicia", "Flora", "Floretta", "Flossie", "Forrest", "France", "Gearldine", "Georgianne", "Germaine", "Gidget", "Giovanna", "Giovanni", "Glennie", "Gregoria", "Gregory", "Han", "Harley", "Hillary", "Huw", "Ikar", "Ileana", "Inge", "Jani", "Jann", "Jaye", "Jane", "Jeanice", "Jeanna", "Jeannine", "Jena", "Jenee", "Jennifer", "Jeraldine", "Jerrica", "Jesenia", "Jessi", "Jessia", "Jestine", "Jina", "Joetta", "John", "Jolanda", "Joseph", "Josphine", "Julie", "Julio", "Jutta", "Kaitlin", "Kami", "Katerine", "Katherine", "Kathrin", "Kayce", "Kaye", "Kayleen", "Keturah", "Keven", "Kevin", "Kimiko", "Kina", "Kristel", "Ladawn", "Latrina", "Laurinda", "Leigh", "Leisha", "Leonore", "Leontine", "Lois", "Luis", "Lyman", "Lynelle", "Madelene", "Mae", "Maegan", "Mai", "Marcell", "Marco", "Mari", "Maria", "Marin", "Marlo", "Marylin", "Mayme", "Meg", "Mel", "Melissia", "Mia", "Michel", "Mirella", "Nadine", "Nannette", "Natisha", "Nedra", "Nestor", "Ngan", "Nichol", "Noe", "Noel", "Noemi", "Numbers", "Odessa", "Omer", "Oralia", "Osvaldo", "Ozell", "Pamella", "Pamila", "Patti", "Rae", "Randell", "Raye", "Rayford", "Regan", "Renay", "Reyes", "Robbyn", "Ronda", "Ronna", "Rosa", "Rosalee", "Rosamond", "Rosana", "Rosanna", "Rosaura", "Rubye", "Ruth", "Sabina", "Sabine", "Sabra", "Samira", "Sandee", "Sandra", "Sandy", "Sarah", "Setsuko", "Shaunte", "Shawana", "Shawanda", "Sina", "Sirena", "Sol", "Solange", "Stefan", "Stefani", "Steffan", "Subira", "Sultan", "Suzi", "Syble", "Tai", "Tammara", "Tawny", "Taylor", "Tenisha", "Terresa", "Tracey", "Trula", "Twanna", "Tyree", "Ulysses", "Vanesa", "Velva", "Velvet", "Verlie", "Viki", "Weldon", "Wendolyn", "Wilfred", "Willis", "Yen", "Yetta", "Yildiz", "Yvette", "Zofia", "Zona", "Zoraida"};
    

	// populate flights and seats table
	public static void populateTableFS(Table<Flight> fTable, Table<Seat> sTable, int nFlights , int nSeats) {
		for(int f = 0; f < nFlights; f++){
        	fTable.add(new Flight(fNames[f], nSeats));
        	sTable.addAll(fTable.get(f).seats);
        }
	}
	
	// populate passengers table
	public static void populateTableP(Table<Passenger> pTable, int nPassengers) {
		for(int p = 0; p < nPassengers; p++){
        	pTable.add(new Passenger(pNames[p]));
        }
	}
	
	// print out the table
	public static void showTable(Table<?> t){
		if(t.get(0).getClass() == Flight.class){
			System.out.println("************ FLIGHTS TABLE **************\nfID\t| fDESTINATION  |   fCAPACITY\t|\n-----------------------------------------");
		} else if(t.get(0).getClass() == Seat.class) {
			System.out.println("*************** SEATS TABLE ******************\nsID\t|  fID\t|  DESTINATION\t|  ISBOOKED  |\n----------------------------------------------");
		} else if(t.get(0).getClass() == Passenger.class) {
			System.out.println("*** PASSENGERS TABLE ****\npID\t|    pNAME\t|\n-------------------------");
		} else if(t.get(0).getClass() == Reservation.class){
			System.out.println("*************** RESERVATIONS TABLE ****************\n      pNAME     |\tsID\t|   DESTINATION   |\n---------------------------------------------------");
		} else {
			System.out.println("No -Headings- for this table");
		}
		for (int i = 0; i < t.size();i++){
			System.out.println(t.get(i));
		}
	}
	
	
}