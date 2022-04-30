package bootcamp.collections.examples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	//create a list
	public static void run() {
		
		//-------------------------------------------------------------------//
		//		Creating a Queue and Performing basic operations like Enqueue and Dequeue
		//-------------------------------------------------------------------//
		
		// Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();

        // Adding new elements to the Queue (The Enqueue operation)
        waitingQueue.add("Michael");
        waitingQueue.add("Chris");
        waitingQueue.add("John");
        waitingQueue.add("Mark");
        waitingQueue.add("Steven");

        System.out.println("WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using remove() (The Dequeue operation)
        // The remove() method throws NoSuchElementException if the Queue is empty
        String name = waitingQueue.remove();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using poll()
        // The poll() method is similar to remove() except that it returns null if the Queue is empty.
        name = waitingQueue.poll();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);
		//-------------------------------------------------------------------//
		//			Peek inside the Queue
		//-------------------------------------------------------------------//
		
        waitingQueue = new LinkedList<>();

        waitingQueue.add("Jennifer");
        waitingQueue.add("Angelina");
        waitingQueue.add("Johnny");
        waitingQueue.add("Sachin");

        System.out.println("WaitingQueue : " + waitingQueue);

        // Check if a Queue is empty
        System.out.println("is waitingQueue empty? : " + waitingQueue.isEmpty());

        // Find the size of the Queue
        System.out.println("Size of waitingQueue : " + waitingQueue.size());

        // Check if the Queue contains an element
        name = "Johnny";
        if(waitingQueue.contains(name)) {
            System.out.println("WaitingQueue contains " + name);
        } else {
            System.out.println("Waiting Queue doesn't contain " + name);
        }

        // Get the element at the front of the Queue without removing it using element()
        // The element() method throws NoSuchElementException if the Queue is empty
        String firstPersonInTheWaitingQueue =  waitingQueue.element();
        System.out.println("First Person in the Waiting Queue (element()) : " + firstPersonInTheWaitingQueue);

        // Get the element at the front of the Queue without removing it using peek()
        // The peek() method is similar to element() except that it returns null if the Queue is empty
        firstPersonInTheWaitingQueue = waitingQueue.peek();
        System.out.println("First Person in the Waiting Queue : " + firstPersonInTheWaitingQueue);


		
		//-------------------------------------------------------------------//
		//				Iterating over a Queue
		//-------------------------------------------------------------------//
		
        // A LinkedList containing Stock Prices of a company for the last 6 days
        waitingQueue = new LinkedList<>();

        waitingQueue.add("John");
        waitingQueue.add("Brad");
        waitingQueue.add("Angelina");
        waitingQueue.add("Julia");

        System.out.println("=== Iterating over a Queue using Java 8 forEach() ===");
        waitingQueue.forEach(personName -> {
            System.out.println(personName);
        });

        System.out.println("\n=== Iterating over a Queue using iterator() ===");
        Iterator<String> waitingQueueIterator = waitingQueue.iterator();
        while (waitingQueueIterator.hasNext()) {
            name = waitingQueueIterator.next();
            System.out.println(name);
        }

        System.out.println("\n=== Iterating over a Queue using iterator() and Java 8 forEachRemaining() ===");
        waitingQueueIterator = waitingQueue.iterator();
        waitingQueueIterator.forEachRemaining(personName -> {
            System.out.println(personName);
        });

        System.out.println("\n=== Iterating over a Queue using simple for-each loop ===");
        for(String personName: waitingQueue) {
            System.out.println(personName);
        }
        
	}
}
