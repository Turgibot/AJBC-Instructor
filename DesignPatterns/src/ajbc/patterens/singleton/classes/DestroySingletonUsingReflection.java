package ajbc.patterens.singleton.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DestroySingletonUsingReflection {

	public static void run() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = null;
		
		Constructor<?>[] constructors = MySingleton.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			constructor.setAccessible(true);
			
			Object object = constructor.newInstance();
			singleton2 = (MySingleton)object;
			
			break;
		}
		
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
		
	}

}
