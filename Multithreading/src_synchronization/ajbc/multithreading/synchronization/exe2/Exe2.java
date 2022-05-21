package ajbc.multithreading.synchronization.exe2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Exe2 {

	private static final int CAPACITY = 5;
	private AnalysisService service;
	private Marketing marketing;

	public Exe2(AnalysisService service, Marketing marketing) {
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
		Queue<String> queue = new LinkedList<>();
		AnalysisService service = new AnalysisService(queue, CAPACITY);
		Marketing marketing = new Marketing(queue, CAPACITY);
		
		Exe2 exeObj = new Exe2(service, marketing);
		exeObj.run();
	}
}