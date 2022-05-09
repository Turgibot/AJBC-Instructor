package ajbc.patterns.state.exe;

public class Has15State extends State {

	Has15State(GumDispenser dispenser) {
		super(dispenser);
	}

	@Override
	public boolean onInsert5() {
		System.out.println("Balance: 20");
		dispenser.changeState(new Has20State(dispenser));
		return false;
	}

	@Override
	public boolean onInsert10() {
		System.out.println("Balance: 25");
		dispenser.changeState(new GotGumState(dispenser));
		return false;
	}
	@Override
	public boolean takeGum() {
		System.out.println("Insufficient funds - I want more ...");
		return false;
	}
}
