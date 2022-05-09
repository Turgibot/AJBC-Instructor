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

		List<Person> people = Arrays.asList(new Person("John", "Travolta", 22), new Person("Sean", "Michaels", 13),
				new Person("Don", "Juan", 17), new Person("Shiri", "Maymon", 38), new Person("Thomas", "Edisson", 120),
				new Person("Liroy", "Fame", 71));

		runExamples();

	}

	public static void runExamples() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Stream<Integer> myStream = list.stream();

		Function<Integer, Double> square = x -> {
			return (double) (x * x);
		};
		Stream<Double> squared = myStream.map(square); // Values are: (1, 4, 9, 16, 25)
		squared.forEach(System.out::println);

		// print each item in the list after adding 1000 to it

		list.stream().map(e -> e + 1000).forEach(z -> System.out.println(z));

		Stream<Integer> stream1 = list.stream().map(e -> e + 1000);

		stream1.filter((e) -> e >= 1003).map(x -> 2 * x).forEach(z -> System.out.println(z));
		;

		Stream<Integer> even = list.stream().filter((x) -> x % 2 == 0); // Values are (2, 4)

		List<Integer> numbers = List.of(1, 2, 2, 2, 3, 3, 3, 5, 4, 5, 6);

		System.out.println("--------------Reduce ------------------");
		numbers = List.of(1, 2, 3, 4, 5, 6);
		int factorial = numbers.stream().reduce(1, (acc, next) -> (acc * next));

		System.out.println("factorial(6) = " + factorial);

		System.out.println("--------------Collect ------------------");

		List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers); // [2, 4, 6]

		Set<Integer> oddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0).collect(Collectors.toSet());
		System.out.println(oddNumbers); // [1, 3, 5]

		numbers = List.of(1, 2, 3, 4, 5, 6);
		Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
				.collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
		System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}
	}
}
