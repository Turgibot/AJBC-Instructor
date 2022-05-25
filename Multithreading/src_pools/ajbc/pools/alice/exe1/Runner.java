package ajbc.pools.alice.exe1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.*;

public class Runner {
	static volatile Map<String, Integer> wordsMap = new HashMap<>();

	public static void main(String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
		File file = new File("alice.txt");

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, // number of threads in normal condition
				4, // in case of many tasks
				1, // thread that idle - waiting for tasks will terminate after this time
				TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), // 3 is the size of the Q . blocking Q uses locks and
																// have threads wait if
				new ThreadPoolExecutor.CallerRunsPolicy());
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {

				String[] words = sc.nextLine().replaceAll("[.,-]", " ").replace('\'', ' ').split(" ");

				threadPoolExecutor.execute(() -> {
					for (String word : words) {
						if (word.isEmpty() || word == null)
							continue;
						synchronized (wordsMap) {
							if (!wordsMap.containsKey(word)) {
								wordsMap.put(word, 1);
							} else {
								wordsMap.put(word, 1 + wordsMap.get(word));
							}
						}
					}
				});
			}
		}

		threadPoolExecutor.shutdown();
		threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS);

		//TODO use Stream API
		List<Entry<String, Integer>> list = new ArrayList<>(wordsMap.entrySet());
		list.sort(Entry.comparingByValue());

		Map<String, Integer> result = new LinkedHashMap<>();
		for (Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		result.entrySet().stream().forEach((s) -> System.out.println(s.getKey() + " : " + s.getValue()));

	}

}