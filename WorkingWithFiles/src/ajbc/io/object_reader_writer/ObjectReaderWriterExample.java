package ajbc.io.object_reader_writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectReaderWriterExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeSimpleData();
		readSimpleData();
		ObjectWriterDemo();
		ObjectReaderDemo();
	}

	private static void readSimpleData() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (FileInputStream file = new FileInputStream("myFiles/objFile.dat");
				// Creates an ObjectOutputStream
				ObjectInputStream objStream = new ObjectInputStream(file);) {
			System.out.println("Double data :" + objStream.readDouble());
			System.out.println("Integer data :" + objStream.readInt());
			System.out.println("String data: " + objStream.readObject());

		}
	}

	private static void ObjectWriterDemo() throws FileNotFoundException, IOException {
		// Creates an object of Dog class
		Dog dog1 = new Dog("Jerry", "Poodle");
		Dog dog2 = new Dog("Spock", "Cocker Spanial");
		Dog dog3 = new Dog("Zoey", "Sibirian Huskey");
		try (FileOutputStream fileOut = new FileOutputStream("myFiles/objFile1.dat");
				// Creates an ObjectOutputStream
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {

			objOut.writeObject(dog1);
			objOut.writeObject(dog2);
			objOut.writeObject(dog3);
		}

	}

	private static void ObjectReaderDemo() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (FileInputStream file = new FileInputStream("myFiles/objFile1.dat");
				// Creates an ObjectOutputStream
				ObjectInputStream objStream = new ObjectInputStream(file);) {
			System.out.println("Dog1 :" + (Dog)objStream.readObject());
			System.out.println("Dog2 :" + (Dog)objStream.readObject());
			System.out.println("Dog3 :" + (Dog)objStream.readObject());


		}

	}

	private static void writeSimpleData() throws IOException {
		int num = 2;
		double money = 234.4;

		String str = "I'm an object";

		try (FileOutputStream file = new FileOutputStream("myFiles/objFile.dat");
				// Creates an ObjectOutputStream
				ObjectOutputStream output = new ObjectOutputStream(file);) {
			output.writeDouble(money);
			output.writeInt(num);
			output.writeObject(str);
		}

	}
}
