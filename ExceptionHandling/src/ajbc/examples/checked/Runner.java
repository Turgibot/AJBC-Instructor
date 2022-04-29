package ajbc.examples.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Runner {

	public static void readFile(String path) throws FileNotFoundException {
		FileReader file = new FileReader(path);
	}

	public static void tryReadFile(String path) {
		try {
			FileReader file = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		String path = "";
		readFile(path);
		tryReadFile(path);

		// how to explicitly throw an exception?
		boolean condition = true;
		try {
			if (condition)
				throw new IOException("explicitly throwing an IO exception");
		} catch (IOException e) {
			System.out.println(e);
			// Do something to deal with the exception
			System.out.println("Something went wrong - take care of it !");

		} finally {
			// this block always gets executed
			System.out.println("No matter what happens this line gets printed");
		}

	}

}
