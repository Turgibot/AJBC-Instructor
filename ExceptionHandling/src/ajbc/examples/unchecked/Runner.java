package ajbc.examples.unchecked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int num1 = 100, res = 0, num2 = 0;
		boolean success = false;
		while (true) {
			System.out.println("Enter a num: ");
			try {
				String input = sc.next();
				num2 = Integer.parseInt(input);
				success = true;
			} catch (NumberFormatException e) {
				// float parsing
				try {
					String msg = e.getMessage();
					int start = msg.indexOf('\"') + 1;
					int end = start + msg.substring(start).indexOf('\"');
					num2 = (int) Float.parseFloat(msg.substring(start, end));
					success = true;
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(null, ne + "\n Input can't be parsed - Try again");
				}
			}
			// if input is valid calculate division
			if (success) {
				try {
					res = num1 / num2;
					break;
				} catch (ArithmeticException e) {
					success = false;
					JOptionPane.showMessageDialog(null, e + "\n Input can't be zero - Try again");
				}
			}
		}
		System.out.println("Result is " + res);
		sc.close();

	}

}
