package ajbc.patterns.decorator.exe;

public class CasualDressDecorator extends DressDecorator {

	public CasualDressDecorator(Dress wrapee) {
		super(wrapee);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println("Casuality Added...");
	}
}
