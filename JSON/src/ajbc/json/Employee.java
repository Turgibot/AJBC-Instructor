package ajbc.json;

import com.google.gson.annotations.SerializedName;

public class Employee {
	private String name;
	private int age;
	@SerializedName("e_mail")
	private String eMail;
	private Address address;

	public Employee() {
	}

	public Employee(String name, int age, String eMail, Address address) {
		this.name = name;
		this.age = age;
		this.eMail = eMail;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", eMail=" + eMail + ", address=" + address + "]";
	}

}
