package ajbc.xml;

public class Student {

	private final long rollNumber;
	private String firstName;
	private String lastName;
	private String nickName;
	private int grade;
	
	public Student(long rollNumber, String firstName, String lastName, String nickName, int grade) {
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nickName=" + nickName + ", grade=" + grade + "]";
	}
	
	
}
