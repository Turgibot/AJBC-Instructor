package bootcamp.learn.generics.exercise;

import java.util.Objects;

//public abstract class Person implements Comparable<Person>{
public abstract class Person implements Acceptable{
	protected long id;
	protected String name;

	
	public Person(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
		
}
