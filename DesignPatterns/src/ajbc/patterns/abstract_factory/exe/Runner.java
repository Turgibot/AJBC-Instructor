package ajbc.patterns.abstract_factory.exe;

import java.util.Scanner;

public class Runner {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Application app = configureApplication();
		app.start();
		
	}

	/**
	 * The concrete factory is usually chosen depending on configuration or
	 * environment options.
	 */
	private static Application configureApplication() {
		ThemeFactory theme;
		System.out.println("Enter 1 for dark 2 for bright");
		int selection = Integer.parseInt(sc.next());
		if (selection == 1) {
			theme = new DarkThemeFactory();
		} else {
			theme = new BrightThemeFactory();
		}
		return new Application(theme);
	}


}
