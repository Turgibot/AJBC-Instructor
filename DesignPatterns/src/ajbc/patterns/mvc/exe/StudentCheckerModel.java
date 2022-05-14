package ajbc.patterns.mvc.exe;

import java.util.List;

public class StudentCheckerModel {
	private String firstName;
	private String lastName;
	private long id;
	private List<Double> grades;
	
	public StudentCheckerModel(String firstName, String lastName, long id, List<Double> grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.grades = grades;
	}
	
	public double calcAverage() {
		return grades.stream().reduce(0.0, (a, b)->a+b)/grades.size();
	}
	
}
