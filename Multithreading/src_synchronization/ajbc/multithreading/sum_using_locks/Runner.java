package ajbc.multithreading.sum_using_locks;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    //REMINDER - SHOW EXAMPLE OF DEAD LOCK SCENARIO
    private static final int NUM_THREADS = 2, SIZE =10; 
    private static int sum = 0;
    private static int[] array = new int[SIZE];
    private static Lock mutex = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            array[i] = 10;
        }

        List<Thread> threads = new ArrayList<>();
        int threadSlice = SIZE/ NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            Thread t = new Thread(new MyThread(i * threadSlice, (i + 1) * threadSlice));
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Sum is: " + sum);
    }

    static class MyThread implements Runnable {
        private final int left;
        private final int right;

        public MyThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            for (int i = left; i < right; i++) {
                mutex.lock();
                sum = sum + array[i];
                mutex.unlock();
                
            }
        }
    }
}