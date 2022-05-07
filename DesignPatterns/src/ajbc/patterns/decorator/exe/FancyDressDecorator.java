package ajbc.patterns.decorator.exe;

public class FancyDressDecorator extends DressDecorator {

	public FancyDressDecorator(Dress wrapee) {
		super(wrapee);
	}

	@Override
	public void create() {
		super.create();
		System.out.println("Fanciness Added...");
	}
}
