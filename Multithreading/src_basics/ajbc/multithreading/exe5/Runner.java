package ajbc.multithreading.exe5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Runner {
	final static int SIZE = 1000;
	static List<Integer> intList1 = new ArrayList<>(SIZE);
	static List<Integer> doubleBy2ValueList = new ArrayList<>();
	static List<String> stringValueList = new ArrayList<>();
	static List<Double> doubleValueList = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < SIZE; i++) {
			intList1.add(i);
		}
		intList1.set(100, null);
		Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable exception) -> {
			System.out.println("Found Null in " + Thread.currentThread().getName());
			System.out.println("doubleValueList size is " + doubleValueList.size());
		});
		Thread thread1 = new Thread(doubleElement, "Thread 1");
		thread1.start();
		Thread thread2 = new Thread(stringifyElement, "Thread 2");
		thread2.setUncaughtExceptionHandler((t, exception) -> {
			System.out.println("Found Null in " + Thread.currentThread().getName());
			System.out.println("stringValueList size is " + stringValueList.size());
		});
		thread2.start();
		Thread thread3 = new Thread(divideElement, "Thread 3");
		thread3.start();

	}

	public static Runnable doubleElement = () -> {
		for (var i : intList1) {
			try {
				doubleBy2ValueList.add(i * 2);
			} catch (NullPointerException e) {
				System.out.println("Found Null in " + Thread.currentThread().getName());
			}
		}
		System.out.println("doubleBy2ValueList size is " + doubleBy2ValueList.size());
	};

	public static Runnable stringifyElement = () -> {
		for (var i : intList1) {
			stringValueList.add("" + (i + 1));
		}
		System.out.println("stringValueList size is " + stringValueList.size());
	};

	public static Runnable divideElement = () -> {
		for (var i : intList1) {
			doubleValueList.add((double) i / 5);
		}
		System.out.println("doubleValueList size is " + doubleValueList.size());
	};
}
