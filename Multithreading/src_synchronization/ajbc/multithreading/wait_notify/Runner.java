package ajbc.multithreading.wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {

	// producer consumer
	static int SIZE_LINIT = 5;

	public static void main(String[] args) {
		// create a data structure to hold the produced data
		Queue<String> queue = new LinkedList<>();

		// lets create the threads

		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		

		producer.start();
		consumer.start();
		
	}

	// lets create a consumer runnable

	static class Consumer implements Runnable {
		private final Queue<String> queue;

		public Consumer(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					consumeData();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private void consumeData() throws InterruptedException {
			synchronized (queue) {
				if (queue.isEmpty()) {
					System.out.println("Consumer has no data to consume - Waiting for producer....");
					queue.wait(); // lock is returned to queue object
				}

				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + " is CONSUMING data with id " + queue.size());
				queue.remove();
				if (queue.size() == 1)
					queue.notify();
			}

		}

	}

	// lets create a producer runnable

	static class Producer implements Runnable {

		private final Queue<String> queue;

		public Producer(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					produceDate();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void produceDate() throws InterruptedException {
			synchronized (queue) {
				if (queue.size() == SIZE_LINIT) {
					System.out.println("Queue is in its size limit - Producer is waiting for Consumption");
					queue.wait();
				}
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " is producing data with id " + queue.size());
				queue.add("element " + queue.size());
				if (queue.size() == SIZE_LINIT - 1)
					queue.notify();
			}
		}

	}

	public static void howToWaitNotify() throws InterruptedException {

		Runner runner = new Runner();
		synchronized (runner) {
			// thread is entering waiting Q
			runner.wait();
		}

		synchronized (runner) {
			// thread is released from waiting Q
			runner.notify();
		}
	}
}
