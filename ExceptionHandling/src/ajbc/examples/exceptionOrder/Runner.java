package ajbc.examples.exceptionOrder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		try {

		System.out.println("Enter a whole number to divide: ");
		int x = scanner.nextInt();

		System.out.println("Enter a whole number to divide by: ");
		int y = scanner.nextInt();

		int z = x / y;

		System.out.println("result: " + z);
		} catch (ArithmeticException e) {
			System.out.println("You can't divide by zero!");
		} catch (InputMismatchException e) {
			System.out.println("PLEASE ENTER A NUMBER!!!");
		} catch (Exception e) {
			System.out.println("Something went wrong : " + e);
		} finally {
			scanner.close();
		}

	}

}
