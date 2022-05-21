package ajbc.multithreading.synchronization.exe3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exe3 {
	private static int sum = 0;
	private static final int BOUND = 1000, NUM_THREADS = 2, SIZE = 50;

	private List<Integer> list;
	private Random rand;
	private Lock lock;

	public Exe3() {

		list = new ArrayList<>();
		rand = new Random(123);
		lock = new ReentrantLock();
	}

	private void initList() {
		for (int i = 0; i < SIZE; i++) {
			list.add(rand.nextInt(BOUND));
		}
	}

	private int sumList() {
		return list.stream().reduce(0, (a, b) -> a + b);
	}

	private void sumList(int start, int end) {
		List<Integer> subList = list.subList(start, end);
		for (Iterator<Integer> iterator = subList.iterator(); iterator.hasNext();) {
			lock.lock();
			sum += iterator.next();
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Exe3 exeObj = new Exe3();
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
		private Exe3 exeObj;

		public MyThread(int start, int end, Exe3 exeObj) {
			this(start, end, exeObj, Thread.currentThread().getName());
		}

		public MyThread(int start, int end, Exe3 exeObj, String name) {
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
				exeObj.lock.lock();
				sum += iterator.next();
				exeObj.lock.unlock();
			}
		}
	};

}