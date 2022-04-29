package ajbc.examples.custom.checked;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Runner {
	public static Scanner sc = new Scanner(System.in);

	public static String checkUserRegistered(String[] users) throws MissingNameException {
		System.out.println("Hello! What is your username?");
		String input = sc.next();
		for (String name : users) {
			if (name.toLowerCase().equals(input.toLowerCase())) {
				return input;
			}
		}
		throw new MissingNameException(input);
	}

	public static void main(String[] args) {
		String[] names = { "Moshe", "David", "Mohammad", "Charly", "Dana", "Rebecca" };
		String msg = "";
		try {
			String userName = checkUserRegistered(names);
			msg = "Welcome back " + userName;
		} catch (MissingNameException e) {
			msg = "Dear " + e.getName() + ", Please register first";
		} finally {
			JOptionPane.showMessageDialog(null, msg);
			sc.close();
		}
	}
}