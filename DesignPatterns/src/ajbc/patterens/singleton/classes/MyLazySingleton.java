package ajbc.patterens.singleton.classes;

public final class MyLazySingleton {
	
	private static MyLazySingleton instance = null;

	public static MyLazySingleton getInstance() {

		if (instance == null) {
			instance = new MyLazySingleton();
		}
		return instance;
	}

	private MyLazySingleton() {
	}
	
	public static void run() {

		/**
		 * Calling getInstance() method many times returns same hashcode that proves
		 * that Singleton class creates only one instance
		 */
		MyLazySingleton singleton1 = MyLazySingleton.getInstance();
		MyLazySingleton singleton2 = MyLazySingleton.getInstance();

		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());

	}
}
