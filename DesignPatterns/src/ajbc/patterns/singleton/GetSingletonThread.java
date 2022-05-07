package ajbc.patterns.singleton;

public class GetSingletonThread implements Runnable{

	@Override
	public void run() {
		MySynchronizedSingleton singleton = MySynchronizedSingleton.getInstance();
		System.out.println(Thread.currentThread().getName()+" "+singleton.hashCode());
	}

}
