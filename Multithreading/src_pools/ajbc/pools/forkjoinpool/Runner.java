package ajbc.pools.forkjoinpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;

public class Runner {
	static char[] array = new char[10000];
	static Map<String, Integer> wordsMap = new HashMap<>();

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
				String[] line = sc.nextLine().replaceAll("[.,-]", " ").replace('\'', ' ').split(" ");
				
				
				
				threadPoolExecutor.execute(()->{
					for (String word : line) {
						if(word.isEmpty()||word==null)
							continue;
						if(!wordsMap.containsKey(word)) {
							wordsMap.put(word, 1);
						}
						else {
							wordsMap.put(word, 1+wordsMap.get(word));
						}
					}
				});
			}
		}
		
		threadPoolExecutor.shutdown(); 
		threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS);
		wordsMap.entrySet().stream().forEach((s)->System.out.println(s.getKey()+" : "+s.getValue()));
		
	}

}