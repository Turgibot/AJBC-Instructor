package bootcamp.learn.generics.exercise;

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

	

	public static Student getBetterStudent(Service<Student> service1, Service<Student> service2) {
		return service1.serviced.aveGrade >= service2.serviced.aveGrade ? service1.serviced : service2.serviced;
	}
	
	

	public static void serve(List<Service<Person>> services) {
		for (Service<? extends Person> service : services) {
			service.service();
			service.getServiced().accept();
		}
	}

	public static void main(String args[]) {
		
		// Exercise 1
		
		System.out.println("------------------1----------------");
		List<Person> people = Arrays.asList(new Customer(123, "Davis", 1), new VIPCustomer(124, "Peter", 2, 100),
				new Student(234, "Sean", 88.8f), new Employee(235, "Alex", 79) );

		System.out.println("Printing persons");
		List<Service< Person>> services = new ArrayList<>();
		for (Person person : people) {
			services.add(new Service<Person>(person, 100));
		}

		System.out.println("Printing Services before");
		printList(services);

		serve(services);
		System.out.println("Printing Services After");
		printList(services);

		// exercise 2
		System.out.println("------------------2----------------");
		Student student3 = new Student(234, "Sean", 88.8f);
		Student student4 = new Student(235, "Alex", 99.8f);

		Service<Student> service1 = new Service<Student>(student3, 111f);
		Service<Student> service2 = new Service<Student>(student4, 222f);
		Student betterStudent = getBetterStudent(service1, service2);
		System.out.println(betterStudent);

		// exercise 3
		System.out.println("------------------3----------------");
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
