package ajbc.patterns.state.exe;

public class GotGumState extends State {

	GotGumState(GumDispenser dispenser) {
		super(dispenser);
	}

	@Override
	public boolean onInsert5() {
		System.out.println("Take the gum first!!");
		return false;
	}

	@Override
	public boolean onInsert10() {
		return onInsert5();
	}
	
	@Override
	public boolean takeGum() {
		System.out.println("Enjoy!!");
		return true;
	}
}
