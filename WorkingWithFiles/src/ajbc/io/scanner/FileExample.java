package ajbc.io.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileExample {

	public static void main(String[] args) throws IOException {

		File file = new File("myFiles/newFile.txt");
		if (!file.exists()) {

			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Failed to create a file " + e);
			}
		} else {

			if (file.delete()) {
				System.out.println("The File is deleted.");
			} else {
				System.out.println("The File is not deleted.");
			}
		}
		
		//create directory
		File theDir = new File("myFiles/images");
		if (!theDir.exists()){
		    theDir.mkdirs();
		}

		// File (or directory) with new name
		File file2 = new File("newname");
		if (file2.exists())
			throw new java.io.IOException("file exists");

		// Rename file (or directory)
		if (file.renameTo(file2)) {
			System.out.println("The File was renamed.");
		} else {
			System.out.println("The File was not renamed.");
		}
		

	}
}
