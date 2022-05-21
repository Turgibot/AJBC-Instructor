package ajbc.multithreading.synchronization.exe4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Marketing {

	private static final int SLEEP = 1000;
	private Queue<String> reports;
	private int capacity;
	private Lock lock;
	private Condition condition;

	public Marketing(Queue<String> reports, int capacity, Lock lock, Condition condition) {
		this.reports = reports;
		this.capacity = capacity;
		this.lock = lock;
		this.condition = condition; 
	}

	public void supply() {
		lock.lock();
		if (reports.isEmpty()) {
			System.out.println("Marketing is waiting for available reports");
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("report" + reports.size() + " got supplied to customer");
		reports.remove();
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (reports.size() == capacity - 1)
			condition.signal();

		lock.unlock();
	}
}
