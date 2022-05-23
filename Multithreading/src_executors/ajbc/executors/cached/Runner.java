package ajbc.executors.cached;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int NUM_THREADS = 3;
	private static int num = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));
		executorService.execute(() -> System.out.println(num++));

		Future<Integer> answer = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws ArithmeticException {
				return 3 / 1;
			}
		});

		int result = answer.get();
		System.out.println(result);

		List<Callable<Integer>> callables = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			callables.add(() -> num++);
		}

		List<Future<Integer>> futures = executorService.invokeAll(callables);
		int sum = 0;
		for (Future<Integer> future : futures) {
			sum += future.get();
		}
		
		System.out.println(sum);
		
		int anyTask = executorService.invokeAny(callables);
		System.out.println(anyTask);
		
		executorService.shutdown();
		executorService.awaitTermination(2, TimeUnit.SECONDS);

	}
}
