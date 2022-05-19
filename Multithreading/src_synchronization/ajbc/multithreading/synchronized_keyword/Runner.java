package ajbc.multithreading.synchronized_keyword;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static int globalCounter = 0;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        ThreadGroup group = new ThreadGroup("Group1");

        for (int i = 1; i<=1000; i++) {
            Thread t = new Thread(group, new MyThread());
            t.start();
            threads.add(t);
        }

        group.interrupt();

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Total = " + globalCounter);
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {

            }
            synchronized (obj) {
                globalCounter++;
            }


//            int localCounter = globalCounter;
//            localCounter = localCounter + 1;
//            globalCounter = localCounter;
        }

        private static void staticIncrement() {
            synchronized (MyThread.class) {

            }
        }
        private synchronized void incrementa() {}
        private void increment() {
            synchronized (this) {

            }
        }
    }
}