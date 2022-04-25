package ajbc.io.reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterExample {

	public static void main(String[] args) {
		//readerDemo();
		writerDemo();

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

	public static void writerDemo() {
		String data = "This is the data in the output file.\n";

        try {
            // Creates a Writer using FileWriter
            Writer output = new FileWriter("myFiles/output.txt");


            // Writes a string to the file
            output.write(data);
            
            output.write('a');
            char[] chars = {'z','b','v','\n'};
            output.write(chars);
            
            // Append data to the file
            data = "And this is the appended data.";
            output.append(data);
            // Closes the writer
            output.close();
            System.out.println("File Writing ended successfully");
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
