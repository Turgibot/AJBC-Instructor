package ajbc.multithreading.synchronization.exe4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class AnalysisService {
	private static final int SLEEP = 2000;
	private Queue<String> reports;
	private int capacity;
	private Lock lock;
	Condition condition;
	public AnalysisService(Queue<String> reports, int capacity, Lock lock, Condition condition) {
		this.reports = reports;
		this.capacity = capacity;
		this.lock = lock;
		this.condition = condition;
		
	}

	public void produce() {
		lock.lock();
		if (reports.size() == capacity) {
			System.out.println("Manufacturer is waiting");
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("report" + reports.size() + " got produced");
		reports.add("report " + reports.size());
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (reports.size() == 1)
			condition.signal();
		lock.unlock();
	}

}
