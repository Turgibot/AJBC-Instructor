package ajbc.patterns.state.exe;

public class StartState extends State {

	StartState(GumDispenser dispenser) {
		super(dispenser);
	}

	@Override
	public boolean onInsert5() {
		System.out.println("Balance: 5");
		dispenser.changeState(new Has5State(dispenser));
		return false;
	}

	@Override
	public boolean onInsert10() {
		System.out.println("Balance: 10");
		dispenser.changeState(new Has10State(dispenser));
		return false;
	}

	@Override
	public boolean takeGum() {
		System.out.println("Insufficient funds - I want more ...");
		return false;
	}

}
