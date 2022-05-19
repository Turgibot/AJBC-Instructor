package ajbc.json;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Home {

	MyAddress address;
	List<Room> rooms;
	boolean hasYard;
	boolean hasBasement;
	double area;
	
	public Home(MyAddress address, List<Room> rooms, boolean hasYard, boolean hasBasement, double area) {
		super();
		this.address = address;
		this.rooms = rooms;
		this.hasYard = hasYard;
		this.hasBasement = hasBasement;
		this.area = area;
	}
	
	public static void create() {
		Home[] homes = new Home[2];
		homes[0] = new Home(new MyAddress("Alabama", "Montgomery", "Atalantic BLVD", 230),
				Arrays.asList(
						new Room(12.5, 10.2, true),
						new Room(5.5, 10.7, true)
						), true, false, 1200.9 );
		homes[1] = new Home(new MyAddress("California", "Los Angeles", "Sunset BLVD", 555),
				Arrays.asList(
						new Room(9.9, 10.9, false),
						new Room(18.5, 11.2, true),
						new Room(8.7, 13.1, true)
						), false, true, 1801.8 );
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(homes));
	}
	
}
