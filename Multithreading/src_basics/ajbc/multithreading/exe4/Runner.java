package ajbc.multithreading.exe4;

import java.util.ArrayList;
import java.util.List;

public class Runner {
	private static final int INDEX = 3;
	final static int SIZE = 1000;
	static List<Integer> intList1 = new ArrayList<Integer>(SIZE);
	static List<Integer> intList2 = new ArrayList<Integer>(SIZE);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < SIZE; i++) {
			intList1.add(i);
			intList2.add(i + SIZE);
		}

		intList1.add(INDEX, -1);

		Thread thread1 = new Thread(hasNegative, "thread1");
		Thread thread2 = new Thread(hasCommon, "thread2");

		thread2.setDaemon(true);

		thread1.start();
		thread2.start();
	}

	static Runnable hasNegative = () -> {

//		int min = intList1.stream().min(Integer::compare).get();
//		
//		if(min>=0)
//			System.out.println(Thread.currentThread().getName()+" didnt find a negative number");
//		else
//			System.out.println(Thread.currentThread().getName()+" found a negative number " + min);

		boolean hasNegative = false;
		for (Integer i : intList1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i < 0) {
				System.out.println(Thread.currentThread().getName() + " found a negative number " + i);
				hasNegative = true;
				return;
			}
		}
		System.out.println(Thread.currentThread().getName() + " didnt find a negative number");
	};

	static Runnable hasCommon = () -> {
		intList2.forEach((i) -> {
			if (intList1.contains(i)) {
				System.out.println(Thread.currentThread().getName() + " found a common integer " + i);
				return;
			}
		});
		System.out.println(Thread.currentThread().getName() + " found that there is no common integer");
	};
}
