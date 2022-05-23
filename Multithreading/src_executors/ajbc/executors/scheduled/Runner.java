package ajbc.executors.scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int NUM_THREADS = 3;
	private static int num = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUM_THREADS);
		executorService.schedule(() -> System.out.println(num++), 5, TimeUnit.SECONDS);
		
		Callable<Integer> task1 = new Callable<Integer>() {

			@Override
			public Integer call() throws ArithmeticException {
				return 3 / 1;
			}
		};
		
		
		ScheduledFuture<Integer> answer = executorService.schedule(task1, 5, TimeUnit.SECONDS);
		

		// init Delay = 5, repeat the Runnable task every 1 second
        executorService.scheduleAtFixedRate(()->System.out.println("java"), 5, 1, TimeUnit.SECONDS);

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
		
//		executorService.shutdown();
//		executorService.awaitTermination(2, TimeUnit.SECONDS);

	}
}
