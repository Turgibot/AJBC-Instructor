package bootcamp.learn.generics.exercise;

public class Student extends Person {
	protected float aveGrade;

	public Student(long id, String name, float grade) {
		super(id, name);
		this.aveGrade = grade;
	}

	@Override
	public String toString() {
		return "Student [grade=" + aveGrade + ", " + super.toString() + "]";
	}

	@Override
	public void accept() {
		aveGrade--;
		
	}
	
}
