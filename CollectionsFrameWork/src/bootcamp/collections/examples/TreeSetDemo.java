package bootcamp.collections.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public class TreeSetDemo {

	public static void run() {

		// -------------------------------------------------------------------//
		// Creating a Simple TreeSet
		// -------------------------------------------------------------------//
		// Creating a TreeSet
		SortedSet<String> fruits = new TreeSet<>();

		// Adding new elements to a TreeSet
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Pineapple");
		fruits.add("Orange");

		System.out.println("Fruits Set : " + fruits);

		// Duplicate elements are ignored
		fruits.add("Apple");
		System.out.println("After adding duplicate element \"Apple\" : " + fruits);

		// This will be allowed because it's in lowercase.
		fruits.add("banana");
		System.out.println("After adding \"banana\" : " + fruits);

		// -------------------------------------------------------------------//
		// TreeSet with a custom comparator (Case Insensitive Order)
		// -------------------------------------------------------------------//

		// Creating a TreeSet with a custom Comparator (Case Insensitive Order)
		fruits = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

		/*
		 * The above TreeSet with the custom Comparator is the concise form of the
		 * following: SortedSet<String> fruits = new TreeSet<>(new Comparator<String>()
		 * {
		 * 
		 * @Override public int compare(String s1, String s2) { return
		 * s1.compareToIgnoreCase(s2); } });
		 */

		// Adding new elements to a TreeSet
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Pineapple");
		fruits.add("Orange");

		System.out.println("Fruits Set : " + fruits);

		// Now, lowercase elements will also be considered as duplicates
		fruits.add("banana");
		System.out.println("After adding \"banana\" : " + fruits);

		// -------------------------------------------------------------------//
		// Tree Set with a custom Comparator (Descending order)
		// -------------------------------------------------------------------//

		// Creating a TreeSet with a custom Comparator (Descending Order)
		fruits = new TreeSet<>(Comparator.reverseOrder());

		/*
		 * The above TreeSet with the custom Comparator is the concise form of the
		 * following: SortedSet<String> fruits = new TreeSet<>(new Comparator<String>()
		 * {
		 * 
		 * @Override public int compare(String s1, String s2) { return s2.compareTo(s1);
		 * } });
		 */

		// Adding new elements to a TreeSet
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Pineapple");
		fruits.add("Orange");

		System.out.println("Fruits Set : " + fruits);

		// -------------------------------------------------------------------//
		// Accessing the elements of a TreeSet
		// -------------------------------------------------------------------//
		TreeSet<String> students = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

		students.add("Julia");
		students.add("Robert");
		students.add("Mark");
		students.add("Steven");

		System.out.println("Students TreeSet : " + students);

		// Finding the size of a TreeSet
		System.out.println("Number of elements in the TreeSet : " + students.size());

		// Check if an element exists in the TreeSet
		String name = "Julia";
		if (students.contains(name)) {
			System.out.println("TreeSet contains the element : " + name);
		} else {
			System.out.println("TreeSet does not contain the element : " + name);
		}

		// Navigating through the TreeSet
		System.out.println("First element : " + students.first());
		System.out.println("Last element : " + students.last());

		name = "Robert";
		System.out.println("Element just greater than " + name + " : " + students.higher(name));
		System.out.println("Element just lower than " + name + " : " + students.lower(name));
		// -------------------------------------------------------------------//
		// Removing elements from a TreeSet
		// -------------------------------------------------------------------//
		TreeSet<Integer> numbers = new TreeSet<>();

		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
		numbers.add(25);
		numbers.add(30);
		numbers.add(42);
		numbers.add(49);
		numbers.add(50);

		System.out.println("numbers TreeSet : " + numbers);

		// Remove an element from the TreeSet
		boolean isRemoved = numbers.remove(49);
		if (isRemoved) {
			System.out.println("After Removing 49 : " + numbers);
		}

		// Remove all elements divisible by 3
		numbers.removeIf(number -> number % 3 == 0);
		System.out.println("After removeIf() : " + numbers);

		// Retrieve and remove the first element from the TreeSet
		Integer num = numbers.pollFirst();
		System.out.println("Removed first element " + num + " from the TreeSet : " + numbers);

		// Retrieve and remove the last element from the TreeSet
		num = numbers.pollLast();
		System.out.println("Removed last element " + num + " from the TreeSet : " + numbers);

		// -------------------------------------------------------------------//
		// TreeSet with user defined objects
		// -------------------------------------------------------------------//

		// Creating a TreeSet of User Defined Objects.

		/*
		 * The requirement for a TreeSet of user defined objects is that
		 * 
		 * 1. Either the class should implement the Comparable interface and provide the
		 * implementation for the compareTo() function. 2. Or you should provide a
		 * custom Comparator while creating the TreeSet.
		 */

		SortedSet<Employee> employees = new TreeSet<>();

		// TreeSet uses the compareTo() method of the Employee class to compare two
		// employees and sort them
		employees.add(new Employee(1010, "Michael"));
		employees.add(new Employee(1005, "David"));
		employees.add(new Employee(1008, "Chris"));

		System.out.println("Employees (sorted based on Employee class's compareTo() function)");
		System.out.println(employees);

		// Providing a Custom Comparator (This comparator compares the employees based
		// on their Name)
		employees = new TreeSet<>(Comparator.comparing(Employee::getName));

		employees.add(new Employee(1010, "Michael"));
		employees.add(new Employee(1005, "David"));
		employees.add(new Employee(1008, "Chris"));

		System.out.println("\nEmployees (sorted based on the supplied Comparator)");
		System.out.println(employees);

	}
}
