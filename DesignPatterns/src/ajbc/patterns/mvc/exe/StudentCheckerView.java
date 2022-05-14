package ajbc.patterns.mvc.exe;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class StudentCheckerView extends View{
	
	public String getFirstName() {
		return getUserInput("What is your first name?");
	}
	
	public String getLastName() {
		return getUserInput("What is your last name?");
	}
	
	public long getId() {
		return Long.parseLong(getUserInput("What is your ID?"));
	}
	
	public double getAverage() {
		return Double.parseDouble(getUserInput("What is your average"));
	}
	
	public List<Double> getGrades(int size){
		List<Double> grades = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			String input = JOptionPane.showInputDialog("Enter grade for course number %d:".formatted(i+1));
			grades.add(Double.parseDouble(input));
		}
		return grades;
	}
}
