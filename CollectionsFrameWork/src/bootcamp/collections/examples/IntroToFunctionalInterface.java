package bootcamp.collections.examples;

public class IntroToFunctionalInterface {
	public static void run() {
		Printable animal1 = new Animal();
		
		//lambdas
		
		//animal1.print();
		//printMe(animal1);
//		printMe(()-> {
//			System.out.println("I'm an Animal Too");
//		});
		
		Printable printableLambda = ()->System.out.println("Hi from functional programming");
		printMe(printableLambda);
		
		//anonymous class
		
		Printable anonyPrintable = new Printable() {
			
			@Override
			public void print() {
				System.out.println("I inherit from Printable");
				
			}
		};
		anonyPrintable.print();
		printMe(anonyPrintable);
	}
	
	public static void printMe(Printable obj) {
		obj.print();
	}
	
	
}
