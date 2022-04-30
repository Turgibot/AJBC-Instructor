package bootcamp.learn.generics;

public abstract class Person {
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
	
	public abstract void accept();

}
