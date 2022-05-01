package ajbc.io.print_writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		
	try (PrintWriter printedFile = new PrintWriter("myFiles/output3.txt")){
		
		int age = 2;
		printedFile.printf("I am %d years old.\n", age);
		printedFile.println("The end!");
	} catch (FileNotFoundException e) {
		System.out.println(e);
	}

	
	}
}
