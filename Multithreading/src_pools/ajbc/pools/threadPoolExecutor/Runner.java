package ajbc.pools.threadPoolExecutor;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int CORE_THREADS = 1;
	private static final int MAX_POOL_SIZE = 3;
	private static final int CAPACITY = 6;

	private static final long KEEP_ALIVE_TIME = 3;
	// thread pools executor
//	private static final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY);
	private static final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
//	private static final BlockingQueue<Runnable> tasks = new SynchronousQueue<>();

	private static RejectedExecutionHandler handler = (Runnable runnable, ThreadPoolExecutor executor) -> {
		// runnable.run();
		// executor.execute(runnable);
		System.out.println("Rejected task");
	};

	// 1 wake up core threads from pool one by one up to CORE_THREADS
	// 2 fill up the queue with tasks one by one up to CAPACITY
	// 3 if necessary wake up more threads up to a total of MAX_POOL_SIZE
	// 4 if queue is full and all threads are running - a RejectedExecutionException
	// is thrown

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
				tasks
		// handler
//				new ThreadPoolExecutor.CallerRunsPolicy()
		);

		Runnable task = () -> {
//			sleep(1000);
			System.out.println("JAVA THREAD");
		};

		// option 1 try catch every execute
//		for (int i = 0; i < 15; i++) {
//			try {
//				pool.execute(task);
//				System.out.println(pool.getPoolSize());
//			} catch (RejectedExecutionException e) {
//				System.out.println("Task is rejected");
//			}
//		}
		// option 2 use pool constructor to handle exception
//		for (int i = 0; i < 15; i++) {
//			pool.execute(task);
//			sleep(1);
//			System.out.println(pool.getPoolSize());
//		}

		Callable<Integer> myCallable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				sleep(5000);
				return 4;
			}
		};

		Future<Integer> future = pool.submit(myCallable);

		if (!future.isDone()) {
			future.cancel(false);
		}

		Future<?> result = pool.submit(task);
		result.get();

		try {

			System.out.println(future.get());
		} catch (CancellationException e) {
			System.out.println("task is cancelled");
		}

		// gracefully shutdown
		pool.shutdown();

		// wait for execution to end
		
		pool.awaitTermination(30, TimeUnit.SECONDS);
	}

	static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}