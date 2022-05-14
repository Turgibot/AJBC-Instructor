package ajbc.patterns.mvc.exe;

import javax.swing.JOptionPane;

public abstract class View {

	protected int showInputDialog(String message) {
		String input = JOptionPane.showInputDialog(message);
		return Integer.parseInt(input);
	}
	
	
	protected <T extends Number> void showMessage(String text, T value) {
		JOptionPane.showMessageDialog(null, text + " " + value);

	}
	
	protected String getUserInput(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
}
