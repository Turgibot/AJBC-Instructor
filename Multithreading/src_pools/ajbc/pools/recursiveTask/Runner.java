package ajbc.pools.recursiveTask;

import java.util.Arrays;
import java.util.concurrent.*;

public class Runner {

    private static int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        
        double[] nums = new double[5000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double)(((i % 2) == 0) ? i : -1);
        }
        Future<Double> future = pool.submit(new SumTask(nums, 0, nums.length));

        double summation = future.get();

        System.out.println("Summation " + summation);
    }

    static class SumTask extends RecursiveTask<Double> {
        final int seqThreshold = 500;
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