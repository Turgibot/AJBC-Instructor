package ajbc.functional.learn;

public class Printer {

	public static void main(String[] args) {

		Printer printer = new Printer();
		String hello = "Hello";
//		activate(printer, hello);

		Printable printable = (x) -> System.out.println(x + " is printed SHasha");
		activate(printable, hello);

		Addable addable = (a, b) -> a + b;
		
		int x = addable.add(3, 6);
		System.out.println(x);
//		activate(addable);
		
		
	}

	public static void activate(Printable printable, String s) {
		printable.print(s);
	}

	public static void activate(Addable addable) {
		System.out.println(addable.add(4, 5));
	}

}
