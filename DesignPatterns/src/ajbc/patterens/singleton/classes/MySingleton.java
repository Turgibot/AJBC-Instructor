package ajbc.patterens.singleton.classes;

public final class MySingleton {

	public static MySingleton getInstance() {
		return instance;
	}

	private static MySingleton instance = new MySingleton();

	private MySingleton() {
	}

	public static void run() {

		/**
		 * Calling getInstance() method many times returns same hashcode that proves
		 * that Singleton class creates only one instance
		 */
		MySingleton singleton1 = MySingleton.getInstance();
		MySingleton singleton2 = MySingleton.getInstance();

		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());

	}
}
