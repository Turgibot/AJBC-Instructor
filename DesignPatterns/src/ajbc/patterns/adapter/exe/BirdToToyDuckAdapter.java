package ajbc.patterns.adapter.exe;

public class BirdToToyDuckAdapter implements ToyDuck{
	Bird bird;
    public BirdToToyDuckAdapter(Bird bird){
        this.bird = bird;
    }

    @Override
    public void squeak() {
    	System.out.println("This may sound like a bird but its a Toy duck squeaking: ");
        bird.makeSound();
    }
}
