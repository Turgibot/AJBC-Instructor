package ajbc.multithreading.synchronization.exe4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exe3 {

	private static final int CAPACITY = 5;
	private AnalysisService service;
	private Marketing marketing;

	public Exe3(AnalysisService service, Marketing marketing) {
		this.service = service;
		this.marketing = marketing;
	}

	public void run() {
		Thread serviceThread = new Thread(() -> {
			while (true)
				service.produce();
		}, "Analysis Service Thread");
		
		Thread marketingThread = new Thread(() -> {
			while (true)
				marketing.supply();
		}, "Marketing Thread");
		
		serviceThread.start();
		marketingThread.start();
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		
		Queue<String> queue = new LinkedList<>();
		AnalysisService service = new AnalysisService(queue, CAPACITY, lock, condition);
		Marketing marketing = new Marketing(queue, CAPACITY, lock, condition);
		
		Exe3 exeObj = new Exe3(service, marketing);
		exeObj.run();
	}
}