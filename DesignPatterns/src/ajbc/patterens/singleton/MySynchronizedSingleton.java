package ajbc.patterens.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class MySynchronizedSingleton {
	// Used to slow down 1st thread
	private static boolean firstThread = true;
	private static MySynchronizedSingleton instance = null;

	public static MySynchronizedSingleton getInstance() {
		
		if (instance == null) {
			if(firstThread) {
				firstThread = false;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//uncomment this line and comment the syncronized block to see how singleton is breakable
			//instance = new MySynchronizedSingleton();
			
			synchronized (MySynchronizedSingleton.class) {
				if (instance == null) {
					
					instance = new MySynchronizedSingleton();
				}
			}
		}
		return instance;
	}

	private MySynchronizedSingleton() {
	}
	
	public static void run() {
		ExecutorService executorService = null;
		GetSingletonThread myThread = new GetSingletonThread();
		try {
			 executorService = Executors.newFixedThreadPool(5);
			 for (int i = 0; i < 10; i++) {
				 executorService.execute(myThread);	
			}
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(executorService != null)
				executorService.shutdown();
		}
	}
}
