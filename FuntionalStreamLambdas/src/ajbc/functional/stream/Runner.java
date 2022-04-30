package ajbc.functional.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
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
		
		runExamples();
		
		
	}
	
	public static void runExamples() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> squared = list.stream().map((x) -> x * x); // Values are: (1, 4, 9, 16, 25)
		Stream<Integer> even = list.stream().filter((x) -> x % 2 == 0); // Values are (2, 4)
		
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		
		List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);  // [2, 4, 6]
		
		Set<Integer> oddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0).collect(Collectors.toSet());
		System.out.println(oddNumbers); // [1, 3, 5]
		
		Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
				.collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
		System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}
	}
}
