package ajbc.functional.stream.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000,
						Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100,
						Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100,
						Continent.Eastern_Kingdoms));

		// 1
		List<String> names = characters.stream().filter((x) -> x.getContinent() == Continent.Kalimdor)
				.map(GameCharacter::getName) // This is java method reference, equivalent to: .map(c -> c.getName())
				.collect(Collectors.toList());
		System.out.println("=====  1  =====");
		System.out.println(names);
		// 2

		System.out.println("=====  2  =====");
//		characters.stream().sorted((g1, g2) -> {
//			double diff = g1.getHitPoints() - g2.getHitPoints();
//			return diff == 0.0 ? 0 : (diff > 0 ? 1 : -1);
//		}).forEach(System.out::println);

		characters.stream().sorted(Comparator.comparing(GameCharacter::getHitPoints)) // Equivalent to comparing(c ->
																						// c.getHitPoints())
				.forEach(System.out::println); // Equivalent to .forEach(c -> System.out.println(c))

		// 3
		List<Double> hitPoints = characters.stream().filter((character) -> character.getLevel() == 120) // Get all level
																										// 120
																										// characters.
				.map(GameCharacter::getHitPoints) // Equivalent to .map(c -> c.getHitPoints()), returns hit points for
													// each character.
				.collect(Collectors.toList());

		double average = hitPoints.stream().reduce(0.0, (acc, next) -> acc + next) / hitPoints.size();
		// Identity (starting) element is 0, sum the elements in hitPoints and divide by
		// hitPoints.size() (3) to get the average.
		System.out.println("=====  3  =====");
		System.out.println("Average : " + average);
		// 4
		List<String> characterNames = Arrays.asList("Durotan", "Grom", "Garrosh", "Garona", "Nazgrim");
		List<GameCharacter> honorableOrcs = characterNames.stream().map((name) -> new GameCharacter(name,
				"Honorable Orc", "Orgrimmar", 15, 200 + (Math.random() * 100), Continent.Kalimdor))
				.collect(Collectors.toList());
		System.out.println("=====  4  =====");
		honorableOrcs.forEach(System.out::println);
	}
}
