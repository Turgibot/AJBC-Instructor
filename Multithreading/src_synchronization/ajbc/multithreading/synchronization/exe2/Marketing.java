package ajbc.multithreading.synchronization.exe2;

import java.util.Queue;

public class Marketing {

	private static final int SLEEP = 1000;
	private Queue<String> reports;
	private int capacity;

	public Marketing(Queue<String> reports, int capacity) {
		this.reports = reports;
		this.capacity = capacity;
	}

	public void supply() {
		synchronized (reports) {
			if (reports.isEmpty()) {
				System.out.println("Marketing is waiting for available reports");
				try {
					reports.wait();
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
				reports.notify();
		}
	}

}
