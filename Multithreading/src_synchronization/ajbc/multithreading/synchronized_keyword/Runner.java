package ajbc.multithreading.synchronized_keyword;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	// Synchronized block and method

	private static int globalCounter = 0;
	private static final Object synchronizer = new Object();
	
	private static Runner runner = new Runner();
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();

		ThreadGroup group = new ThreadGroup("Group1");

		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(group, new MyThread());
			t.start();
			threads.add(t);
		}

		group.interrupt();

		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println("Total = " + globalCounter);
	}

	static class MyThread implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(99999);
			} catch (InterruptedException e) {

			}
			//1 not synchronized:
			
			globalCounter++;

//          int localCounter = globalCounter;
//          localCounter = localCounter + 1;
//          globalCounter = localCounter;
			
			
			//2 using synchronized block
			
//            synchronized (synchronizer) {
//                globalCounter++;
//            }

			//3. synchronized method
			//runner.incrementCounter();
			//or
			//runner.increment();
		}
	}

	private synchronized void incrementCounter() {
		globalCounter++;
	}

	private void increment() {
		synchronized (this) {
			globalCounter++;
		}
	}
}