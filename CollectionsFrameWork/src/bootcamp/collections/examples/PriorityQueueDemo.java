package bootcamp.collections.examples;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
	// create a list
	public static void run() {

		// -------------------------------------------------------------------//
		// Creating a Priority Queue
		// -------------------------------------------------------------------//

		// Create a Priority Queue
		PriorityQueue<Integer> numbers = new PriorityQueue<>();

		// Add items to a Priority Queue (ENQUEUE)
		numbers.add(750);
		numbers.add(500);
		numbers.add(900);
		numbers.add(100);

		// Remove items from the Priority Queue (DEQUEUE)
		while (!numbers.isEmpty()) {
			System.out.println(numbers.remove());
		}

		// Let’s see the same example with a Priority Queue of String elements.

		// Create a Priority Queue
		PriorityQueue<String> namePriorityQueue = new PriorityQueue<>();

		// Add items to a Priority Queue (ENQUEUE)
		namePriorityQueue.add("Lisa");
		namePriorityQueue.add("Robert");
		namePriorityQueue.add("John");
		namePriorityQueue.add("Chris");
		namePriorityQueue.add("Angelina");
		namePriorityQueue.add("Joe");

		// Remove items from the Priority Queue (DEQUEUE)
		while (!namePriorityQueue.isEmpty()) {
			System.out.println(namePriorityQueue.remove());
		}

		// -------------------------------------------------------------------//
		// Creating a Priority Queue with a custom Comparator
		// -------------------------------------------------------------------//

		// A custom comparator that compares two Strings by their length.
		Comparator<String> stringLengthComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		};

		/*
		 * The above Comparator can also be created using lambda expression like this =>
		 * Comparator<String> stringLengthComparator = (s1, s2) -> { return s1.length()
		 * - s2.length(); };
		 * 
		 * Which can be shortened even further like this => Comparator<String>
		 * stringLengthComparator = Comparator.comparingInt(String::length);
		 */

		// Create a Priority Queue with a custom Comparator
		namePriorityQueue = new PriorityQueue<>(stringLengthComparator);

		// Add items to a Priority Queue (ENQUEUE)
		namePriorityQueue.add("Lisa");
		namePriorityQueue.add("Robert");
		namePriorityQueue.add("John");
		namePriorityQueue.add("Chris");
		namePriorityQueue.add("Angelina");
		namePriorityQueue.add("Joe");

		// Remove items from the Priority Queue (DEQUEUE)
		while (!namePriorityQueue.isEmpty()) {
			System.out.println(namePriorityQueue.remove());
		}

		// -------------------------------------------------------------------//
		// Priority Queue of user defined objects
		// -------------------------------------------------------------------//
		/*
		 * The requirement for a PriorityQueue of user defined objects is that
		 * 
		 * 1. Either the class should implement the Comparable interface and provide the
		 * implementation for the compareTo() function. 2. Or you should provide a
		 * custom Comparator while creating the PriorityQueue.
		 */

		// Create a PriorityQueue
		PriorityQueue<Worker> workerPriorityQueue = new PriorityQueue<>();

		// Add items to the Priority Queue
		workerPriorityQueue.add(new Worker("Michael", 100000.00));
		workerPriorityQueue.add(new Worker("Chris", 145000.00));
		workerPriorityQueue.add(new Worker("Andrea", 115000.00));
		workerPriorityQueue.add(new Worker("Jack", 167000.00));

		/*
		 * The compareTo() method implemented in the Employee class is used to determine
		 * in what order the objects should be dequeued.
		 */
		while (!workerPriorityQueue.isEmpty()) {
			System.out.println(workerPriorityQueue.remove());
		}

	}
}
