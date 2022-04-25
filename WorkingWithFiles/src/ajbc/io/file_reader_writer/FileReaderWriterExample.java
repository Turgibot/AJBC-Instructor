package ajbc.io.file_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;

public class FileReaderWriterExample {

	public static void main(String[] args) {
		readerDemo();

	}
	
	public static void readerDemo() {
		// Creates an array of character
        char[] array = new char[100];
        try {
            // Creates a reader using the FileReader
            Reader input = new FileReader("myFiles/input.txt");

            // Checks if reader is ready 
            System.out.println("Is there data in the stream?  " + input.ready());

            // Reads characters
            input.read(array);
            System.out.println("Data in the stream:");
            System.out.println(array);

            // Closes the reader
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e);;
         }
        catch(IOException e) {
            System.out.println(e);;
         }
        catch(Exception e) {
            System.out.println(e);;
         }
	}

}
