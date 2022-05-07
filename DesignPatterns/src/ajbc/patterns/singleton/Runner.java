package ajbc.patterns.singleton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Runner {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, ClassNotFoundException, IOException {

		MySingleton.run();
		MyLazySingleton.run();
		MySynchronizedSingleton.run();
		DestroySingletonUsingReflection.run();
		MySerializedSingleton.run();
		SingletonEnum.run();
	}

	
}
