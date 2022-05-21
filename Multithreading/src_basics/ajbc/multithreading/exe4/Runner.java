package ajbc.multithreading.exe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
	private static final int INDEX = 5000;
	final static int SIZE = 100000;
	static List<Integer> intList1 = new ArrayList<Integer>(SIZE);
	static List<Integer> intList2 = new ArrayList<Integer>(SIZE);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < SIZE; i++) {
			intList1.add(i);
			intList2.add(i + SIZE);
		}
		intList1.set(INDEX, -4);

		Thread thread1 = new Thread(hasNegative, "Negative Finder Thread");
		Thread thread2 = new Thread(hasCommonElement, "Common Finder Thread");
		thread2.setDaemon(true);
		thread1.start();
		thread2.start();
	}

	static Runnable hasCommonElement = () -> {
		// assuming the intList2 is sorted - if not simply sort it before
		for (Integer i : intList1) {
//			if (intList2.contains(i)) {
//				System.out.println(Thread.currentThread().getName() + " FOUND a common value");
//				return;
//			}
			int result = Collections.binarySearch(intList2, i);
			if(result>=0) {
				System.out.println(Thread.currentThread().getName()+" FOUND a common value");
				return;
			}
		}
		System.out.println(Thread.currentThread().getName() + " did NOT find a common value");
	};

	static Runnable hasNegative = () -> {
		for (Integer i : intList1) {
			try {
				Thread.sleep(1);
				if (i < 0) {
					System.out.println(Thread.currentThread().getName() + " FOUND a negative value");
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " did NOT find a negative value");
	};
}
