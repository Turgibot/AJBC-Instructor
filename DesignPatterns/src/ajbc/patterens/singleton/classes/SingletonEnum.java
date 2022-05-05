package ajbc.patterens.singleton.classes;

public enum SingletonEnum {
	INSTANCE;
	
	public String welcome() {
		return "Singleton!!";
	}
	
	public static void run() {
		SingletonEnum singleton1 = SingletonEnum.INSTANCE;
		SingletonEnum singleton2 = SingletonEnum.INSTANCE;
		
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
		
		String welcome = singleton1.welcome();
		System.out.println(welcome);
	}
}
