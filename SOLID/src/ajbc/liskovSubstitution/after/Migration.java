package ajbc.liskovSubstitution.after;


public class Migration {
	
	public void flySouth(Flying... wingedAnimals) {
		for (Flying animal : wingedAnimals) {
			animal.fly();
		}
	}
	
	
	public void Quacking(Duck... ducks) {
		for (Duck duck: ducks) {
			duck.quack();
		}
	}
	
	

}
