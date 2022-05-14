package ajbc.patterns.mvc.exe;

import java.util.List;

public class StudentCheckerController {
	private final int TH_GRADE = 90;
	private final int NUM_GRADES = 3;
	private StudentCheckerView view;
	private StudentCheckerModel student;
	
	public StudentCheckerController(StudentCheckerView view) {
		this.view = view;
	}

	void run() {
		String fName = view.getFirstName();
		String lName = view.getLastName();
		long id = view.getId();
		List<Double> grades = view.getGrades(NUM_GRADES);
		
		student = new StudentCheckerModel(fName, lName, id, grades);
		double average = student.calcAverage();
		String msg = average>=TH_GRADE?"Excelent":"Great";
		msg+=" Student with average :";
		view.showMessage(msg, average);
	}
}
