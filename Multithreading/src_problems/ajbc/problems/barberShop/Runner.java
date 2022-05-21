package ajbc.problems.barberShop;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	// -------- 1 -----------
	private static int waitingCustomers = 0;
	private static Lock waitingCustomersLock = new ReentrantLock();

	// -------- 1 -----------
	private static Semaphore customerArrivedSema = new Semaphore(0);
	private static Semaphore barberReadySema = new Semaphore(0);

	private static Semaphore customerFinished = new Semaphore(0);
	private static Semaphore barberFinished = new Semaphore(0);

	private static String customerName = "";
	private static Semaphore nameExchanged = new Semaphore(0);

	public static void main(String[] args) {
		new Thread(new Barber()).start();

		for (int i = 0; i < 10; i++) {
			new Thread(new Customer("John_" + i)).start();
		}

	}

	static class Barber implements Runnable {

		@Override
		public void run() {
			// the barber is a long live thread that keeps getting customers
			while (true) {
				// -------- 2 -----------
				acquire(customerArrivedSema);
				// -------- 5 -----------
				// The barber is taking the next customer from the waiting room
				barberReadySema.release();

				// -------- 6 -----------
				// haircut simulation
				System.out.println("[BARBER] Doing the hair cut " + customerName);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				barberFinished.release();
				acquire(customerFinished);

			}
		}

		void acquire(Semaphore semaphore) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Customer implements Runnable {

		private static final int NUM_SEATS = 5;
		private final String name;

		public Customer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			// -------- 1 -----------
			waitingCustomersLock.lock();
			if (waitingCustomers == NUM_SEATS) {
				// release the lock before existing the thread
				waitingCustomersLock.unlock();
				System.out.println("Room is full, customer " + name + " leaves");
				// close the thread
				return;
			}

			waitingCustomers++;
			waitingCustomersLock.unlock();

			// -------- 3 -----------
			// a customer arrived releases barber from waiting
			customerArrivedSema.release();

			// -------- 4 -----------
			// a customer is waiting for the barber to be available
			acquire(barberReadySema);

			 
		
			acquire(barberFinished);
			customerFinished.release();

			// -------- 1 -----------
			// when customer leaves decrease waiting clients
			waitingCustomersLock.lock();
			waitingCustomers--;
			waitingCustomersLock.unlock();
		}

		void acquire(Semaphore semaphore) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}