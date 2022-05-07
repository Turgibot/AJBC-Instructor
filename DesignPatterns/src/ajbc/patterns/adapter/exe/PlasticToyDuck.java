package ajbc.patterns.adapter.exe;

public class PlasticToyDuck implements ToyDuck{

	@Override
	public void squeak() {
		System.out.println("PlasticToyDuck is squeaking");
	}

}
