package ajbc.patterns.factory.method.exe;

import java.util.Scanner;

public class Runner {
	private static ThemeFactory theme;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		configure();
		runBusinessLogic();
		
	}

	/**
	 * The concrete factory is usually chosen depending on configuration or
	 * environment options.
	 */
	private static void configure() {
		System.out.println("Enter 1 for dark 2 for bright");
		int selection = Integer.parseInt(sc.next());
		if (selection == 1) {
			theme = new DarkThemeFactory();
		} else {
			theme = new BrightThemeFactory();
		}
	}

	/**
	 * All of the client code should work with factories and products through
	 * abstract interfaces. This way it does not care which factory it works with
	 * and what kind of product it returns.
	 */
	private static void runBusinessLogic() {
		theme.renderWindow();
	}
}
