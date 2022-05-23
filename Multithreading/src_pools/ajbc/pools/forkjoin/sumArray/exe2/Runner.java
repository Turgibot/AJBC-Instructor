package ajbc.pools.forkjoin.sumArray.exe2;

import java.util.Arrays;
import java.util.concurrent.*;

public class Runner {

    private static int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        
        double[] nums = new double[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        Future<Double> future = pool.submit(new SumTask(nums, 0, nums.length));

        double summation = future.get();
        
        pool.shutdown();
		pool.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Summation " + summation);
    }

    static class SumTask extends RecursiveTask<Double> {
        final int seqThreshold = 1;
        double[] data;
        int start, end;
      
        SumTask(double[] data, int start, int end)
        {
            this.data = data;
            this.start = start;
            this.end = end;
        }
      
        @Override
        protected Double compute()
        {
            double sum = 0;
            if ((end - start) < seqThreshold) {
                for (int i = start; i < end; i++)
                    sum += data[i];
            }
            else {
                int middle = (start + end) / 2;
      
                SumTask subtaskA = new SumTask(data, start, middle);
                SumTask subtaskB = new SumTask(data, middle, end);
      
                subtaskA.fork();
                subtaskB.fork();
      
                sum = subtaskA.join() + subtaskB.join();
            }
            return sum;
        }
    }
}