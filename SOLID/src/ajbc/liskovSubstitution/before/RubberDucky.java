package ajbc.liskovSubstitution.before;

public class RubberDucky implements Quackable {

//	public void fly() {
//		throw new UnsupportedOperationException();
//	}
	@Override
	public void quack() {
		System.out.println("Quack! Quack! Quack!");
	}	

}
