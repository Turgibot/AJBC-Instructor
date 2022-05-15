package ajbc.json;

public class Address {

	private String state;
	private String city;

	public Address() {
	}

	public Address(String state, String city) {
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}

}
