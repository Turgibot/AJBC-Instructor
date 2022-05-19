package ajbc.multithreading.exe2;

import java.util.Iterator;

public class Runner {

	public static int num = 10;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("num is "+num);
		Thread thread1 = new Thread(()->doubleTheNum());
		Thread thread2 = new Thread(()->addTwo());
		Thread thread3 = new Thread(()->divideByTwo());
		
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread3.start();
		thread2.start();
		thread1.start();
		
		
		
		thread1.join();
		thread2.join();
		thread3.join();
		System.out.println("num is "+num);
		
	}

	public static void doubleTheNum() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 3; i++) {
			num *= 2;
			System.out.println(thread.getName() + ": " + num);
		}

	}

	public static void addTwo() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 3; i++) {
			num += 2;
			System.out.println(thread.getName() + ": " + num);
		}

	}

	public static void divideByTwo() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 3; i++) {
			num /= 2;
			System.out.println(thread.getName() + ": " + num);
		}

	}
}
