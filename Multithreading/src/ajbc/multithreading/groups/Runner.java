package ajbc.multithreading.groups;

public class Runner {
	public static int num = 1;
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group1 = new ThreadGroup("Group1");

		Thread thread1 = new Thread(group1, new MyThread(), "Thread1");
		Thread thread2 = new Thread(group1, new MyThread(), "Thread2");
		Thread thread3 = new Thread(group1, new MyThread(), "Thread3");

		
		thread1.start();
		thread2.start();
		thread3.start();

		
		System.out.println("Sleeping before interrupt for 3 seconds...");
		Thread.sleep(2000);

		group1.interrupt();
	}

	static class MyThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
					num*=2;
					System.out.println(Thread.currentThread().getName()+": "+num);
				} catch (InterruptedException e) {
					Thread currentThread = Thread.currentThread();
					System.out.println("Name: " + currentThread.getName() + " priority = " + currentThread.getPriority());
					return;
				}
			}
		}
	}
}
