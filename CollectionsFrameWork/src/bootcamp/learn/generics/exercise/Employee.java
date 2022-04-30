package bootcamp.learn.generics.exercise;

public class Employee extends Person {
	protected double salary;

	public Employee(long id, String name, int salary) {
		super(id, name);
		setSalary(salary);
	}

	
	private void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public void accept() {
		salary*=1.01f;
	}


	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", " + super.toString() + "]";
	}

	
}
