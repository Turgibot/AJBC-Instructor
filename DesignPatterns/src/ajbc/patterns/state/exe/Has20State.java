package ajbc.patterns.state.exe;

public class Has20State extends State {

	Has20State(GumDispenser dispenser) {
		super(dispenser);
	}

	@Override
	public boolean onInsert5() {
		System.out.println("Balance: 25");
		dispenser.changeState(new GotGumState(dispenser));
		return false;
	}

	@Override
	public boolean onInsert10() {
		System.out.println("Exact change must be insterted - Use a 5 cents coin instead");
		return false;
	}
	
	@Override
	public boolean takeGum() {
		System.out.println("Insufficient funds - I want more ...");
		return false;
	}
}
