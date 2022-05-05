package ajbc.patterens.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MySerializedSingleton implements Serializable{
	
	public static MySerializedSingleton getInstance() {
		return instance;
	}

	private static MySerializedSingleton instance = new MySerializedSingleton();

	private MySerializedSingleton() {
	}
	
	/**
	 * This method protecting to break singleton
	 * by using Serialization process
	 * @return return singleton instance
	 */
	public Object readResolve() {
		return getInstance();
	}
	
	
	public static void run() throws FileNotFoundException, IOException, ClassNotFoundException {

		MySerializedSingleton singleton1 = MySerializedSingleton.getInstance();
		MySerializedSingleton singleton2 = null;
		try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {

			objectOutput.writeObject(singleton1);

			objectOutput.flush();
		}

		try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("singleton.ser"))) {

			Object readObject = objectInput.readObject();

			singleton2 = (MySerializedSingleton) readObject;

		}

		/**
		 * hascode of original singleton object(singleton1) and serialized
		 * object(singleton2) are same so singleton has not broken.
		 */
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
	}
}
