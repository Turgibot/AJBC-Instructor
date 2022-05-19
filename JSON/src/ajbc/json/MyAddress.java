package ajbc.json;

public class MyAddress extends Address{

	String street;
	int number;

	public MyAddress() {
	}

	public MyAddress(String state, String city, String street, int number) {
		super(state, city);
		this.street = street;
		this.number = number;
		
	}
}
