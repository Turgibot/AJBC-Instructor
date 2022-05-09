package ajbc.functional.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("John", "Travolta", 22),
				new Person("Sean", "Michaels", 13),
				new Person("Don", "Juan", 17),
				new Person("Shiri", "Maymon", 38),
				new Person("Thomas", "Edisson", 120),
				new Person("Liroy", "Fame", 71));
		
		
		people.forEach(p->System.out.println(p));
		
		
		
		System.out.println("-----------------------------------------");
		
		Collections.sort(people, (p1, p2)->p1.lName.compareTo(p2.lName));
		people.forEach(p->System.out.println(p));	
		System.out.println("-----------------------------------------");
		people.forEach(p->{
			if(!p.fName.contains("o")) {
				System.out.println(p);
			}
			
		});
		System.out.println("-----------------------------------------");
		List<Person> under21 = people.stream().filter(p->p.age<=21).collect(Collectors.toList());
		
		under21.stream().forEach(System.out::println);
		System.out.println("----------MyForEach------------------");
		myForEach(people, 
				p->{
			p.age +=1000;
			System.out.println(p);
		});
	}
	//list.myForEach(()->{});
	private static <T> void myForEach(List<T> list, Consumer<T> consumer){
		//list.forEach(consumer);
		Iterator<T> iterator = list.iterator();
		while(iterator.hasNext()) {
			T t = iterator.next();
			consumer.accept(t);
		}
	}
}
