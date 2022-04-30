package bootcamp.collections.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void run() {

		// -------------------------------------------------------------------//
		// Creating and Initializing a LinkedHashMap
		// -------------------------------------------------------------------//

		// Creating a LinkedHashMap
        LinkedHashMap<String, Integer> wordNumberMapping = new LinkedHashMap<>();

        // Adding new key-value pairs to the LinkedHashMap
        wordNumberMapping.put("one", 1);
        wordNumberMapping.put("two", 2);
        wordNumberMapping.put("three", 3);
        wordNumberMapping.put("four", 4);

        // Add a new key-value pair only if the key does not exist in the LinkedHashMap, or is mapped to `null`
        wordNumberMapping.putIfAbsent("five", 5);

        System.out.println(wordNumberMapping);

		// -------------------------------------------------------------------//
		// Accessing the entries of a LinkedHashMap
		// -------------------------------------------------------------------//

        LinkedHashMap<Integer, String> customerIdNameMapping = new LinkedHashMap<>();

        customerIdNameMapping.put(1001, "Jack");
        customerIdNameMapping.put(1002, "David");
        customerIdNameMapping.put(1003, "Steve");
        customerIdNameMapping.put(1004, "Alice");
        customerIdNameMapping.put(1005, "Marie");

        System.out.println("customerIdNameMapping : " + customerIdNameMapping);

        // Check if a key exists in the LinkedHashMap
        Integer id = 1005;
        if(customerIdNameMapping.containsKey(id)) {
            System.out.println("Found the customer with id " + id + " : " + customerIdNameMapping.get(id));
        } else {
            System.out.println("Customer with id " + id + " does not exist");
        }

        // Check if a value exists in the LinkedHashMap
        String name = "David";
        if(customerIdNameMapping.containsValue(name)) {
            System.out.println("A customer named " + name + " exist in the map");
        } else {
            System.out.println("No customer found with name " + name + " in the map");
        }

        // Change the value associated with an existing key
        id = 1004;
        customerIdNameMapping.put(id, "Bob");
        System.out.println("Changed the name of customer with id " + id + ", New mapping : " + customerIdNameMapping);
        

		// -------------------------------------------------------------------//
		// Removing entries from a LinkedHashMap
		// -------------------------------------------------------------------//

        LinkedHashMap<String, String> husbandWifeMapping = new LinkedHashMap<>();

        husbandWifeMapping.put("Michael", "Jennifer");
        husbandWifeMapping.put("John", "Maria");
        husbandWifeMapping.put("Chris", "Lisa");
        husbandWifeMapping.put("Steve", "Susan");

        System.out.println("husbandWifeMapping : " + husbandWifeMapping);

        // Remove a key from the LinkedHashMap
        String wife = husbandWifeMapping.remove("John");
        System.out.println("Removed John and his wife " + wife + " from the mapping. New husbandWifeMapping : " + husbandWifeMapping);

        // Remove a key from the LinkedHashMap only if it is mapped to the given value
        boolean isRemoved = husbandWifeMapping.remove("John", "Susan");
        System.out.println("Did John get removed from the mapping? : " + isRemoved);
        

		// -------------------------------------------------------------------//
		// Iterating over a LinkedHashMap
		// -------------------------------------------------------------------//
        Map<String, String> countryISOCodeMapping = new HashMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");
        countryISOCodeMapping.put("China", "CN");

        // HashMap's entry set
        Set<Map.Entry<String, String>> countryISOCodeEntries = countryISOCodeMapping.entrySet();
        System.out.println("countryISOCode entries : " + countryISOCodeEntries);

        // HashMap's key set
        Set<String> countries = countryISOCodeMapping.keySet();
        System.out.println("countries : " + countries);

        // HashMap's values
        Collection<String> isoCodes = countryISOCodeMapping.values();
        System.out.println("isoCodes : " + isoCodes);

		// -------------------------------------------------------------------//
		// Iterating over a HashMap
		// -------------------------------------------------------------------//
        LinkedHashMap<String, String> userCityMapping = new LinkedHashMap<>();

        userCityMapping.put("Michael", "Bengaluru");
        userCityMapping.put("Chris", "London");
        userCityMapping.put("David", "Paris");
        userCityMapping.put("Jesse", "California");

        System.out.println("=== Iterating over a LinkedHashMap using Java 8 forEach and lambda ===");
        userCityMapping.forEach((user, city) -> {
            System.out.println(user + " => " + city);
        });

        System.out.println("\n=== Iterating over the LinkedHashMap's entrySet using Java 8 forEach and lambda ===");
        userCityMapping.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });

        System.out.println("\n=== Iterating over the entrySet of a LinkedHashMap using iterator() ===");
        Iterator<Map.Entry<String, String>> userCityMappingIterator = userCityMapping.entrySet().iterator();
        while (userCityMappingIterator.hasNext()) {
            Map.Entry<String, String> entry = userCityMappingIterator.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\n=== Iterating over the entrySet of a LinkedHashMap using iterator() and forEachRemaining ===");
        userCityMappingIterator = userCityMapping.entrySet().iterator();
        userCityMappingIterator.forEachRemaining(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });

		// -------------------------------------------------------------------//
		// HashMap with User defined objects
		// -------------------------------------------------------------------//
        LinkedHashMap<Integer, Employee> employeesMap = new LinkedHashMap<>();

        employeesMap.put(1001, new Employee(1001, "Michael", "Bengaluru"));
        employeesMap.put(1002, new Employee(1002, "David", "New York"));
        employeesMap.put(1003, new Employee(1003, "Jack", "Paris"));

        System.out.println(employeesMap);
	}
}
