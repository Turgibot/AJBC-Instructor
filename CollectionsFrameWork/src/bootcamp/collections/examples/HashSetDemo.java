package bootcamp.collections.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetDemo {

	public static void run() {

		// -------------------------------------------------------------------//
		// Creating a LinkedHashSet and adding new elements to it.
		// -------------------------------------------------------------------//

		// Creating a HashSet
		Set<String> daysOfWeek = new HashSet<>();

		// Adding new elements to the HashSet
		daysOfWeek.add("Monday");
		daysOfWeek.add("Tuesday");
		daysOfWeek.add("Wednesday");
		daysOfWeek.add("Thursday");
		daysOfWeek.add("Friday");
		daysOfWeek.add("Saturday");
		daysOfWeek.add("Sunday");

		// Adding duplicate elements will be ignored
		daysOfWeek.add("Monday");

		System.out.println(daysOfWeek);

		// -------------------------------------------------------------------//
		// Creating a HashSet from another collection
		// -------------------------------------------------------------------//

		List<Integer> numbersDivisibleBy5 = new ArrayList<>();
		numbersDivisibleBy5.add(5);
		numbersDivisibleBy5.add(10);
		numbersDivisibleBy5.add(15);
		numbersDivisibleBy5.add(20);
		numbersDivisibleBy5.add(25);

		List<Integer> numbersDivisibleBy3 = new ArrayList<>();
		numbersDivisibleBy3.add(3);
		numbersDivisibleBy3.add(6);
		numbersDivisibleBy3.add(9);
		numbersDivisibleBy3.add(12);
		numbersDivisibleBy3.add(15);

		// Creating a HashSet from another collection (ArrayList)
		Set<Integer> numbersDivisibleBy5Or3 = new HashSet<>(numbersDivisibleBy5);

		// Adding all the elements from an existing collection to a HashSet
		numbersDivisibleBy5Or3.addAll(numbersDivisibleBy3);

		System.out.println(numbersDivisibleBy5Or3);

		// -------------------------------------------------------------------//
		// HashSet simple operations
		// -------------------------------------------------------------------//

		Set<String> popularCities = new HashSet<>();

		// Check if a HashSet is empty
		System.out.println("Is popularCities set empty? : " + popularCities.isEmpty());

		popularCities.add("London");
		popularCities.add("New York");
		popularCities.add("Paris");
		popularCities.add("Dubai");

		// Find the size of a HashSet
		System.out.println("Number of cities in the HashSet " + popularCities.size());

		// Check if the HashSet contains an element
		String cityName = "Paris";
		if (popularCities.contains(cityName)) {
			System.out.println(cityName + " is in the popular cities set.");
		} else {
			System.out.println(cityName + " is not in the popular cities set.");
		}

		// -------------------------------------------------------------------//
		// Removing elements from a HashSet
		// -------------------------------------------------------------------//
		Set<Integer> numbers = new HashSet<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);

		System.out.println("numbers : " + numbers);

		// Remove an element from a HashSet (The remove() method returns false if the
		// element does not exist in the HashSet)
		boolean isRemoved = numbers.remove(10);
		System.out.println(isRemoved + "; After remove(10) => " + numbers);

		// Remove all elements belonging to a given collection from a HashSet
		List<Integer> perfectSquares = new ArrayList<>();
		perfectSquares.add(4);
		perfectSquares.add(9);

		numbers.removeAll(perfectSquares);
		System.out.println("After removeAll(perfectSquares) => " + numbers);

		// Remove all elements matching a given predicate
		numbers.removeIf(num -> num % 2 == 0);
		System.out.println("After removeIf() => " + numbers);

		// Remove all elements from HashSet (clear it completely)
		numbers.clear();
		System.out.println("After clear() => " + numbers);

		// -------------------------------------------------------------------//
		// Iterating over a HashSet
		// -------------------------------------------------------------------//
		Set<String> programmingLanguages = new HashSet<>();
		programmingLanguages.add("C");
		programmingLanguages.add("C++");
		programmingLanguages.add("Java");
		programmingLanguages.add("Python");
		programmingLanguages.add("PHP");
		programmingLanguages.add("Ruby");

		System.out.println("=== Iterate over a HashSet using Java 8 forEach and lambda ===");
		programmingLanguages.forEach(programmingLanguage -> {
			System.out.println(programmingLanguage);
		});

		System.out.println("=== Iterate over a HashSet using iterator() ===");
		Iterator<String> programmingLanguageIterator = programmingLanguages.iterator();
		while (programmingLanguageIterator.hasNext()) {
			String programmingLanguage = programmingLanguageIterator.next();
			System.out.println(programmingLanguage);
		}

		System.out.println("=== Iterate over a HashSet using iterator() and Java 8 forEachRemaining() method ===");
		programmingLanguageIterator = programmingLanguages.iterator();
		programmingLanguageIterator.forEachRemaining(programmingLanguage -> {
			System.out.println(programmingLanguage);
		});

		System.out.println("=== Iterate over a HashSet using simple for-each loop ===");
		for (String programmingLanguage : programmingLanguages) {
			System.out.println(programmingLanguage);
		}

		// -------------------------------------------------------------------//
		// HashSet with User defined objects
		// -------------------------------------------------------------------//
		Set<Customer> customers = new HashSet<>();
        customers.add(new Customer(101, "Shooki"));
        customers.add(new Customer(102, "Shoola"));
        customers.add(new Customer(103, "Shoshi"));

        /*
          HashSet will use the `equals()` & `hashCode()` implementations 
          of the Customer class to check for duplicates and ignore them
        */
        if(!customers.add(new Customer(101, "Shoshana"))) {
        System.out.println("101 is already taken");	
        }

        System.out.println(customers);
	}
}
