package ajbc.patterns.singleton;

public final class MyEnumSingleton {

	public static MyEnumSingleton getInstance() {
		if (instance == null) {
			instance = new MyEnumSingleton();
		}
		return instance;
	}

	private static MyEnumSingleton instance = null;

	private MyEnumSingleton() {}
}
