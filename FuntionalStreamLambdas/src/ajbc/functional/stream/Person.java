package ajbc.functional.stream;

public class Person {
	String fName;
	String lName;
	int age;
	public Person(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [fName=" + fName + ", lName=" + lName + "]";
	}
	
	
}
