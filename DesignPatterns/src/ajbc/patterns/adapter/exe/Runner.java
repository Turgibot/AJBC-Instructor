package ajbc.patterns.adapter.exe;

public class Runner {

	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		PlasticToyDuck toyDuck = new PlasticToyDuck();
		BirdToToyDuckAdapter birdAdapter = new BirdToToyDuckAdapter(sparrow);

		sparrow.fly();
		sparrow.makeSound();
		toyDuck.squeak();
		birdAdapter.squeak();
	}

}
