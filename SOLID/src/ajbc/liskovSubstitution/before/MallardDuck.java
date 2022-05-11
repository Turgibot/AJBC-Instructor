package ajbc.liskovSubstitution.before;

public class MallardDuck implements Flyable, Quackable {

	@Override
	public void fly() {
		System.out.println("Fly, fly, fly!");
	}
	@Override
	public void quack() {
		System.out.println("Quack! Quack! Quack!");
	}	

}
