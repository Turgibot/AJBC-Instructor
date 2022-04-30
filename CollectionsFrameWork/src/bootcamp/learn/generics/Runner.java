package bootcamp.learn.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Runner {

//	public static <T, K, V> boolean isEqual(DataHolder<T, K, V> g1, DataHolder<T, K, V> g2) {
//		return g1.getData().equals(g2.getData());
//	}
//
//	public static <T extends Person> int comparePerson(T t1, T t2) {
//		return t1.compareTo(t2);
//	}
//
//	public static <T extends Comparable<T>> int compareComparable(T t1, T t2) {
//		return t1.compareTo(t2);
//	}
//
//	public static <T extends Customer> int compareCustomer(T t1, T t2) {
//		return t1.compareTo(t2);
//	}
//
//	public static <T extends VIPCustomer> int compareVIP(T t1, T t2) {
//		return t1.compareTo(t2);
//	}
//
//	public static <T extends VIPCustomer & Runnable> int compareRunnableVIP(T t1, T t2) {
//		return t1.compareTo(t2);
//	}

	public static void printList(List<?> list) {
		for (var item : list) {
			System.out.println(item);
		}
	}

	public static <T> boolean isEqualData(DataHolder<T> dataHolder1, DataHolder<T> dataHolder2) {
		return dataHolder1.getData().equals(dataHolder2.getData());
	}

	public static Student getBetterStudent(Service<Student> service1, Service<Student> service2) {
		return service1.serviced.aveGrade >= service2.serviced.aveGrade ? service1.serviced : service2.serviced;
	}

	public static double sum(List<? extends Number> myList) {
		double sum = 0.0;
		for (Number iterator : myList) {
			sum = sum + iterator.doubleValue();
		}
		return sum;
	}

	public static void printIntegerOrSuper(List<? super Integer> list) {
		System.out.println(list);
	}

	public static void main(String args[]) {
		// Generics class
		Customer customer1 = new Customer(123, "Davis", 1);
		DataHolder<Customer> customerData = new DataHolder<>(customer1);
		Customer customer2 = new Customer(124, "Peter", 2);
		customerData.setData(customer2);
		Student student1 = new Student(234, "Sean", 88.8f);
		DataHolder<Student> studentData = new DataHolder<>(student1);
		Student student2 = new Student(235, "Alex", 79.8f);

		// generic interface
		MapDataHolder<Long, Person> dataMap = new MapDataHolder<Long, Person>(new HashMap<Long, Person>());
		dataMap.addItem(customer1.getId(), customer1);
		dataMap.addItem(customer2.getId(), customer2);

		String value = dataMap.getStrValueByKey(customer2.getId());
		System.out.println(value);

//		boolean isEqual = isEqualData(customerData, studentData); //not the same T Type 
		boolean isEqual = isEqualData(customerData, customerData);
		System.out.println(isEqual);

		// bounded type parameters

		// DataHolderCompared<Student> dataHolderCompared = new
		// DataHolderCompared<Student>(student1); //Bound mismatch
		DataHolderCompared<String> dataHolderCompared = new DataHolderCompared<String>("Test");

		// Generics and Inheritance

		Integer myInt = 123;
		Number myNum = myInt;

		ArrayList<Integer> myInts = new ArrayList<>();
		// ArrayList<Number> myNums = myInts;

		// unbounded wildcards

		List<String> strings = new ArrayList<>();
		strings.add("Hi");
		strings.add("T");

		List<?> anythings = strings;
		printList(anythings);

		strings.add("added");
		// anythings.add("no no no!!!");
		anythings.add(null); // but null is okay

		// upper bounded wildcards

		// Upper Bounded Integer List
		List<Integer> intList = Arrays.asList(10, 20, 30, 40);
		// printing the sum of integer elements in list
		System.out.println("Total sum is:" + sum(intList));
		// Upper Bounded Double list
		List<Double> doubleList = Arrays.asList(13.2, 15.6, 9.7, 22.5);
		// printing the sum of double elements in list
		System.out.println("Total sum is: " + sum(doubleList));

		// WildCards and Inheritance

		ArrayList<Integer> myWildInts = new ArrayList<>();
		ArrayList<? extends Number> myWildNums = myInts;

		// Lower Bounded Wildcards

		// Lower Bounded Integer List
		List<Integer> intsList = Arrays.asList(10, 20, 30, 40);
		// Passing Integer list object
		printIntegerOrSuper(intsList);
		// Number list
		List<Number> numberList = Arrays.asList(10.2d, 202.2, 30, 40);
		// Passing Integer list object
		printIntegerOrSuper(numberList);

		// Person customer1 = new Customer(123, "Davis", 1) ;
		// Person customer2 = new Customer(124, "Peter", 2) ;
		// Person student1 = new Student(234, "Sean", 88.8f);
		// Person student2 = new Student(235, "Alex", 79.8f);

		//
		// Exercise 1
		List<Person> people = Arrays.asList(new Customer(123, "Davis", 1), new Customer(124, "Peter", 2),
				new Student(234, "Sean", 88.8f), new Student(235, "Alex", 79.8f));

		List<Service<Person>> services = new ArrayList<>();
		for (Person person : people) {
			services.add(new Service<Person>(person, 0));
		}

		printList(services);

		for (Service<Person> service : services) {
			service.service();
		}

		printList(services);

		// exercise 2

		Student student3 = new Student(234, "Sean", 88.8f);
		Student student4 = new Student(235, "Alex", 99.8f);

		Service<Student> service1 = new Service<Student>(student3, 111f);
		Service<Student> service2 = new Service<Student>(student4, 222f);
		Student betterStudent = getBetterStudent(service1, service2);
		System.out.println(betterStudent);

		// exercise 3

		List<Customer> customers = Arrays.asList(new Customer(123, "Davis", 10), new Customer(124, "Peter", 22),
				new VIPCustomer(234, "Sean", 7, 2222f), new VIPCustomer(235, "Alex", 2, 5553f));
		Collections.sort(customers);
		printList(customers);

		// exercise 4

//		int resultPerson = comparePerson(customer1, customer2);
//		int resultPersonComparable = compareComparable(customer1, customer2);
//		//int resultPersonCustomer = compareCustomer(customer1, customer2);//person doesn't extend VIPCustomer
//		//int resultVIP= compareVIP(customer1, customer2); //person doesn't extend VIPCustomer
//		
//		int resultStudentPerson = comparePerson(student1, student2);
//		int resultStudentComparable = compareComparable(student1, student2);
//		//int resultStudentCustomer= compareCustomer(student1, student2); //Student doesn't extend Customer
//		
//		VIPCustomer customer3 = new VIPCustomer(123, "Davis", 1, 100f) ;
//		VIPCustomer customer4 = new VIPCustomer(124, "Peter", 2, 122f) ;
//		
//		int resultCustomerPerson = comparePerson(customer2, customer3);
//		int resultComparableCustomer= compareComparable(customer4, customer2);
//		int resultCustomerCustomer= compareCustomer(customer3, customer4); 
//		int resultVIP= compareVIP(customer3, customer4); 

//		Serviceable<String> repairService = new RepairService<>("Repairing");

	}

}
