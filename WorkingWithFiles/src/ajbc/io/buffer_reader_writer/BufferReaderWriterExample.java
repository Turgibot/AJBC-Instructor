package ajbc.io.buffer_reader_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReaderWriterExample {

	public static void main(String[] args) {
		readerDemo();
		writerDemo();

	}

	public static void readerDemo() {
		// Creates an array of character
		char[] array = new char[100];
		try (
				// Creates a FileReader
				FileReader file = new FileReader("myFiles/input.txt");
				// Creates a BufferedReader
				BufferedReader input = new BufferedReader(file);) {
			// Checks if reader is ready
			System.out.println("Is there data in the stream?  " + input.ready());

			// Reads characters
			input.read(array);
			System.out.println("Data in the stream:");
			System.out.println(array);

		} catch (

		FileNotFoundException e) {
			System.out.println(e);
			;
		} catch (IOException e) {
			System.out.println(e);
			;
		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}

	public static void writerDemo() {
		String data = "This is the data in the output file.\n";

		try (// Creates a FileWriter
				FileWriter file = new FileWriter("myFiles/output2.txt");

				// Creates a BufferedWriter
				BufferedWriter output = new BufferedWriter(file)) {

			// Writes a string to the file
			output.write(data);

			output.write('a');
			char[] chars = { 'z', 'b', 'v', '\n' };
			output.write(chars);

			// Append data to the file
			data = "And this is the appended data.";
			output.append(data);
			// Closes the writer
			output.close();
			System.out.println("File Writing ended successfully");
		}

		catch (FileNotFoundException e) {
			System.out.println(e);
			;
		} catch (IOException e) {
			System.out.println(e);
			;
		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}
}
