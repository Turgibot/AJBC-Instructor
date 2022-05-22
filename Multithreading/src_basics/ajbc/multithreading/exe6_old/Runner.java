package ajbc.multithreading.exe6_old;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Runner {
	// We have to learn synchronization first but failing is learning

	final static int SIZE = 1000000;
	final static int NUM_THREADS = 2;
	static double sum = 0;
	static List<Double> list1 = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		Instant start1 = Instant.now();
		for (int i = 0; i < SIZE; i++) {
			list1.add(Math.random());
//			list1.add((double)i);
		}
		Instant stop1 = Instant.now();
		Duration duration1 = Duration.between(start1, stop1);
		System.out.println("Sum: " + sum);
		System.out.println("summing using main thread took " + duration1.toMillis() + "ms.");

		List<Thread> threads = new ArrayList<>();
		ThreadGroup group = new ThreadGroup("Group1");
		sum = 0;
		for (int i = 0; i < NUM_THREADS; i++) {
			Thread t = new Thread(group, new MyThread());
			t.start();
			threads.add(t);
		}
		
		group.interrupt();
		
		Instant start2 = Instant.now();
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Instant stop2 = Instant.now();
		Duration duration2 = Duration.between(start2, stop2);
		System.out.println("Sum: " + sum);
		System.out.println("summing using threads took " + duration2.toMillis() + "ms.");
	}

	static class MyThread implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {

			}
			for (int i = 0; i < SIZE/NUM_THREADS; i++) {
				list1.add(Math.random());
			}
		}

	}
}
