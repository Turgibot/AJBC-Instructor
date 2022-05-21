package ajbc.multithreading.synchronization.exe1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Exe1 {
	private static int sum = 0;
	private static final int BOUND = 1000, NUM_THREADS = 2, SIZE = 50;

	private List<Integer> list;
	private Random rand;

	public Exe1() {

		list = new ArrayList<>();
		rand = new Random(123);
	}

	private void initList() {
		for (int i = 0; i < SIZE; i++) {
			list.add(rand.nextInt(BOUND));
		}
	}

	private int sumList() {
		return list.stream().reduce(0, (a, b) -> a + b);
	}

	private synchronized void sumList(int start, int end) {
		List<Integer> subList = list.subList(start, end);
		for (Iterator<Integer> iterator = subList.iterator(); iterator.hasNext();) {
			sum += iterator.next();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Exe1 exeObj = new Exe1();
		exeObj.initList();
		System.out.println("serialized result = " + exeObj.sumList());

		List<Thread> threads = new ArrayList<>();
		int sectionSize = SIZE / NUM_THREADS;
		for (int i = 0; i < NUM_THREADS; i++) {
			Thread thread = new MyThread(i * sectionSize, (i + 1) * sectionSize, exeObj, "MyThread + " + (i + 1));
			thread.start();
			threads.add(thread);
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("parallel result = " + sum);
	}

	private static class MyThread extends Thread {
		private int start;
		private int end;
		private Exe1 exeObj;

		public MyThread(int start, int end, Exe1 exeObj) {
			this(start, end, exeObj, Thread.currentThread().getName());
		}

		public MyThread(int start, int end, Exe1 exeObj, String name) {
			super(name);
			this.start = start;
			this.end = end;
			this.exeObj = exeObj;
		}

		@Override
		public void run() {
			// in a block
//			sumList();
			// in a method
			exeObj.sumList(start, end);
		}

		private void sumList() {
			List<Integer> subList = exeObj.list.subList(start, end);
			for (Iterator<Integer> iterator = subList.iterator(); iterator.hasNext();) {
				synchronized (exeObj) {
					sum += iterator.next();
				}
			}
		}
	};

}