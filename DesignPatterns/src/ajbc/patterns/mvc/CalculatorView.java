package ajbc.patterns.mvc;

import javax.swing.JOptionPane;

public class CalculatorView {

	
	public int getFirstNum() {		
		return showInputDialog("What is the first number?");
	}

	public int getSecondNum() {		
		return showInputDialog("and the second number?");
	}

	private int showInputDialog(String message) {
		String input = JOptionPane.showInputDialog(message);
		return Integer.parseInt(input);
	}

	public void showAnswer(int answer) {
		JOptionPane.showMessageDialog(null, "Answer: "+answer);
		
	}
}
