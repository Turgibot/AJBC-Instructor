package ajbc.patterns.decorator.exe;

public class DressDecorator implements Dress{
	private Dress wrapee;

	public DressDecorator(Dress wrapee) {
		this.wrapee = wrapee;
	}

	@Override
	public void create() {
		wrapee.create();
	}
	
}
