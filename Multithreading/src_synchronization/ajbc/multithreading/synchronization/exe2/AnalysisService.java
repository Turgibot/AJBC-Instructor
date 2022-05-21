package ajbc.multithreading.synchronization.exe2;

import java.util.Queue;

public class AnalysisService {
	private static final int SLEEP = 2000;
	private Queue<String> reports;
	private int capacity;

	public AnalysisService(Queue<String> reports, int capacity) {
		this.reports = reports;
		this.capacity = capacity;
	}

	public void produce() {
		synchronized (reports) {
			if (reports.size() == capacity) {
				System.out.println("Manufacturer is waiting");
				try {
					reports.wait();
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
				reports.notify();
		}
	}
}
