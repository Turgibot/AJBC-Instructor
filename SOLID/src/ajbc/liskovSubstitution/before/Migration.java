package ajbc.liskovSubstitution.before;


public class Migration {
	// ... is named varargs 
	// Duck[] ducks
	// flySouth(ducks)
	// flySouth()
	// flySouth(duck1)
	// flySouth(duck1, duck2)
	// flySouth(duck1, duck2, duck3 ------->>>>)
	
	public void flySouth(Flyable... ducks) {
		for (var duck : ducks) {
			duck.fly();
		}
	}
	
	public void quacking(Quackable... ducks) {
		for (Quackable duck : ducks) {
			duck.quack();
		}
	}

}
