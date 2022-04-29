package ajbc.examples.custom.unchecked;

import java.time.LocalDate;

public class User {
	String name;
	long id;
	LocalDate bDay;
	
	public User(String name, long id, LocalDate bDay) {
		this.name = name;
		this.id = id;
		this.bDay = bDay;
	}
	
	
}
