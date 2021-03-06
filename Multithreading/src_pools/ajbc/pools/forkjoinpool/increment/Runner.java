package ajbc.pools.forkjoinpool.increment;

import java.util.Arrays;
import java.util.concurrent.*;

public class Runner {

	private static int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool pool = new ForkJoinPool(2);

		pool.execute(new IncrementTask(0, 8));
		
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("The array is: " + Arrays.toString(array));
	}

	static class IncrementTask extends RecursiveAction {
		private final int left;
		private final int right;

		public IncrementTask(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		protected void compute() {
			if (right - left < 3) {
				for (int i = left; i < right; i++) {
					array[i]++;
				}
			} else {
				int mid = (left + right) / 2;
				invokeAll(new IncrementTask(left, mid), new IncrementTask(mid, right));
			}
		}
	}
}