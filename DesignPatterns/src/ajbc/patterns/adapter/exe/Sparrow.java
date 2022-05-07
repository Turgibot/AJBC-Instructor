package ajbc.patterns.adapter.exe;

public class Sparrow implements Bird {
	public void fly() {
		System.out.println("Sparrow : Flying");
	}

	public void makeSound() {
		System.out.println("Sparrow : Chirp Chirp");
	}
}
