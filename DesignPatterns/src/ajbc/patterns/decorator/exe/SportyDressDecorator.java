package ajbc.patterns.decorator.exe;

public class SportyDressDecorator extends DressDecorator {

	public SportyDressDecorator(Dress wrapee) {
		super(wrapee);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println("Sportiness Added...");
	}
}
