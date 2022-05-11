package ajbc.patterns.singleton.exercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Runner {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, ClassNotFoundException, IOException {

		List<Player>players = Arrays.asList(
				new Player("Moshe"),
				new Player("David"),
				new Player("Haya"),
				new Player("Shoola")
				);
		GameManager manager = new GameManager(players);
		manager.play();
	
	}

	
}
