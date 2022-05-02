package ajbc.liskovSubstitution.before;


public class Migration {
	
	public void flySouth(Duck... ducks) {
		for (Duck duck : ducks) {
			duck.fly();
		}
	}
	
	public void quacking(Duck... ducks) {
		for (Duck duck : ducks) {
			duck.quack();
		}
	}

}
