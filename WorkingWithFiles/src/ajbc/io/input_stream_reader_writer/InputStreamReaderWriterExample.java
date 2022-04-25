package ajbc.io.input_stream_reader_writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class InputStreamReaderWriterExample {

	public static void main(String[] args) {
		readerDemo();
		writerDemo();

	}

	public static void readerDemo() {
		// Creates an array of character
		char[] array = new char[100];
		try (// Creates a FileInputStream
			      FileInputStream file = new FileInputStream("myFiles/input.txt");

			      // Creates an InputStreamReader with default encoding
				  // change to UTF-16
			      InputStreamReader input = new InputStreamReader(file,Charset.forName("UTF8"));) {
			// Creates a reader using the FileReader

			// Checks if reader is ready
			System.out.println("Is there data in the stream?  " + input.ready());

			// Reads characters
			input.read(array);
			System.out.println("Data in the stream:");
			System.out.println(array);

		} catch (FileNotFoundException e) {
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

		String data = "This is a line of text inside the file.";

		try (  // Creates a FileOutputStream
				FileOutputStream file = new FileOutputStream("myFiles/output1.txt");
				// Creates an OutputStreamWriter
				OutputStreamWriter output = new OutputStreamWriter(file, Charset.forName("UTF16"))) {
			
			// Writes string to the file
			output.write(data);

		}

		catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
			;
		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}
}
