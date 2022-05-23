package ajbc.executors.fixed.exe4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int NUM_THREADS = 3;
	private static int num = 0;

	public static void main(String[] args)
			throws InterruptedException, ExecutionException, MalformedURLException, IOException {

		URLConnection connection = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)")
				.openConnection();
		Scanner sc = new Scanner(connection.getInputStream());

		ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

		while (sc.hasNext()) {
			String line = sc.nextLine().toLowerCase();
			futures.add(executorService.submit(() -> {
				int counter = 0;
				for (String word : line.split(" ")) {
					if (word.equals("java"))
						counter++;
				}
				return counter;
			}));

		}

		int sum = 0;
		for (Future<Integer> future : futures) {
			sum += future.get();
		}

		System.out.println(sum);

	

		executorService.shutdown();
		executorService.awaitTermination(2, TimeUnit.SECONDS);

	}
}
