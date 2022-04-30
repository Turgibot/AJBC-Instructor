package bootcamp.collections.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Predicate;

public class StackDemo {

	public static void run() {
		
		//-------------------------------------------------------------------//
		// Creating a Stack and Performing basic operations like push, pop and peek
		//-------------------------------------------------------------------//
		
		// Creating a Stack
        Stack<String> stackOfCards = new Stack<>();

        // Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Stack => " + stackOfCards);
        System.out.println();

        // Popping items from the Stack
        String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        System.out.println();

        // Get the item at the top of the stack without removing it
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        
        
		//-------------------------------------------------------------------//
		//				Other Stack Operations
		//-------------------------------------------------------------------//
		
        stackOfCards = new Stack<>();

        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Stack : " + stackOfCards);

        // Check if the Stack is empty
        System.out.println("Is Stack empty? : " + stackOfCards.isEmpty());

        // Find the size of Stack
        System.out.println("Size of Stack : " + stackOfCards.size());

        // Search for an element
        // The search() method returns the 1-based position of the element from the top of the stack
        // It returns -1 if the element was not found in the stack
        int position = stackOfCards.search("Queen");

        if(position != -1) {
            System.out.println("Found the element \"Queen\" at position : " + position);
        } else {
            System.out.println("Element not found");
        }
        
        
		//-------------------------------------------------------------------//
		//				Iterating over a Stack
		//-------------------------------------------------------------------//
		
        // A LinkedList containing Stock Prices of a company for the last 6 days
        Stack<String> stackOfPlates = new Stack<>();

        stackOfPlates.add("Plate 1");
        stackOfPlates.add("Plate 2");
        stackOfPlates.add("Plate 3");
        stackOfPlates.add("Plate 4");

        System.out.println("=== Iterate over a Stack using Java 8 forEach() method ===");
        stackOfPlates.forEach(plate -> {
            System.out.println(plate);
        });

        System.out.println("\n=== Iterate over a Stack using iterator() ===");
        Iterator<String> platesIterator = stackOfPlates.iterator();
        while (platesIterator.hasNext()) {
            String plate = platesIterator.next();
            System.out.println(plate);
        }

        System.out.println("\n=== Iterate over a Stack using iterator() and Java 8 forEachRemaining() method ===");
        platesIterator = stackOfPlates.iterator();
        platesIterator.forEachRemaining(plate -> {
            System.out.println(plate);
        });

        System.out.println("\n=== Iterate over a Stack from TOP to BOTTOM using listIterator() ===");
        // ListIterator allows you to traverse in both forward and backward directions.
        // We'll start from the top of the stack and traverse backwards.
        ListIterator<String> platesListIterator = stackOfPlates.listIterator(stackOfPlates.size());
        while (platesListIterator.hasPrevious()) {
            String plate = platesListIterator.previous();
            System.out.println(plate);
        }
        
	}
}
