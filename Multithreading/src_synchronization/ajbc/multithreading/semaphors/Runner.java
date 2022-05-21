package ajbc.multithreading.semaphors;
import java.util.concurrent.Semaphore;

public class Runner {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {

        Executor executor = new Executor();

        executor.submit(new Job(1001));
        executor.submit(new Job(1002));
        executor.submit(new Job(1003));

        executor.submit(new Job(1004));
        executor.submit(new Job(1005));
    }

    static class Executor {
        public void submit(Job job) throws InterruptedException {
            System.out.println("Launching job " + job.getWork());
            semaphore.acquire();

            Thread t = new Thread(() -> {
                try {
                    System.out.println("Executing job " + job.getWork());
                    Thread.sleep(job.getWork());

                    semaphore.release();
                    System.out.println("Job finished with id " + job.getWork());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t.start();
        }
    }

    static class Job {
        private final int work;

        public Job(int work) {
            this.work = work;
        }

        public int getWork() {
            return work;
        }
    }
}