package ajbc.patterns.state.exe;

import java.util.Scanner;

public class GumDispenserHandler {

	private GumDispenser gumDispeser;
	private Scanner scanner;

	public GumDispenserHandler() {
		this.gumDispeser = new GumDispenser();
		scanner = new Scanner(System.in);
	}

	public void simulate() {
		System.out.println("Welcome to the Gum dispenser Simulator");
		boolean gotGum = false;
		while (!gotGum) {
			showOptions();
			int opt = Integer.parseInt(scanner.next());
			gotGum = act(opt);
		}
	}

	private boolean act(int opt) {
		System.out.println("Processing....");
		State state = gumDispeser.getState();
		return opt == 1 ? state.onInsert5() :opt == 2? state.onInsert10(): state.takeGum();
	}

	private void showOptions() {
		System.out.println("Please enter:");
		System.out.println("1 - if you're inserting a 5 cents coin");
		System.out.println("2 - if you're inserting a 10 cents coin");
		System.out.println("3 - To collect the gum...");
	}
}
