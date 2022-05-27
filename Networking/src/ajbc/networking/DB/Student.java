package ajbc.networking.DB;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 453424856140356728L;
	private static long counter = 1000;
	private final long ID; 
	private String name;
	private int age;
	
	public Student(String name, int age) {
		ID = counter++;
		this.name = name;
		this.age = age;
	}

	public Student() {
		this("NA", -1);
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}
	
}
