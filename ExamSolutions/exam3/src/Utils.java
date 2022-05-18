package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utils {
	
	private final String path = "myFiles/objfile.dat";
	private final int NUM_OBJECTS = 4;
	
	protected ObjectOutputStream output;
	protected FileOutputStream file;
	
	public Utils()
	{
		try 
		{
			file = new FileOutputStream(path);
			output = new ObjectOutputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void writeRandomObjectToFile(Object[] objects)
	{
		int index = (int) (Math.random() * NUM_OBJECTS);
		try {
			output.writeObject(objects[index]);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public void readAndPrintObjectsFromFile()
	{
		try (FileInputStream file = new FileInputStream(path);
				ObjectInputStream input = new ObjectInputStream(file))
		{
			Object obj1 = input.readObject();
			System.out.println("Object 1: "+obj1);
			Object obj2 = input.readObject();
			System.out.println("Object 2: "+obj2);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void closeResources()
	{
		try {
			output.close();
			file.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
