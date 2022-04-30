package bootcamp.learn.generics;

import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>{
	protected int salary;

	public Employee(long id, String name, int salary) {
		super(id, name);
		setSalary(salary);
	}

	
	private void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public void accept() {
		salary*=1.01f;
	}


	@Override
	public int compareTo(Employee o) {
		return this.salary-o.salary;
	}


	@Override
	public int hashCode() {
		return Objects.hash(salary);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return salary == other.salary;
	}
	
	
}
