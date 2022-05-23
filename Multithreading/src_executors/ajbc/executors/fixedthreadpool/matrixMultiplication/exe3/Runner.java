package ajbc.executors.fixedthreadpool.matrixMultiplication.exe3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Runner {
	private static final int N = 2000;

	private static final Random random = new Random();

	private static final int[][] A = new int[N][N];
	private static final int[][] B = new int[N][N];
	private static final int[][] C = new int[N][N];
	private static final int[][] Cserial = new int[N][N];

	// Serial, 2K x 2K
	// Run 1 -> 54.48 seconds
	// Run 2 -> 54.15 seconds
	// Run 3 -> 53.80 seconds

	// Block parallel, 2K x 2K (4 threads)
	// Run 1 -> 23.81 seconds
	// Run 2 -> 24.20 seconds
	// Run 3 -> 25.16 seconds

	public static void main(String[] args) throws InterruptedException {
		initMatrixes();

//		printMatrix(A);
//		printMatrix(B);

		long start1 = System.nanoTime();

		multiplySerial();
		long end1 = System.nanoTime();

		System.out.println("Serial Execution time = " + (end1 - start1));

		long start2 = System.nanoTime();

		multiplyParallel();
		long end2 = System.nanoTime();

		System.out.println("Parallel Execution time = " + (end2 - start2));
//		checkResult();
//
//		printMatrix(C);
	}

	static void multiplyParallel() throws InterruptedException {
		ExecutorService threadPool = Executors.newWorkStealingPool(8);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				threadPool.submit(new MatrixMultiplyTask(i, j));
			}
		}

		threadPool.shutdown();
		threadPool.awaitTermination(1, TimeUnit.MINUTES);
	}

	static class MatrixMultiplyTask implements Runnable {

		private final int line;
		private final int column;

		public MatrixMultiplyTask(int line, int column) {
			this.line = line;
			this.column = column;
		}

		@Override
		public void run() {
			C[line][column] = 0;
			for (int i = 0; i < N; i++) {
				C[line][column] += A[line][i] * B[i][column];
			}
		}

	}

	static void multiplySerial() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Cserial[i][j] = 0;
				for (int k = 0; k < N; k++) {
					Cserial[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}

	static void initMatrixes() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = 1;
				B[i][j] = 1;
			}
		}
	}

	static void checkResult() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (C[i][j] != Cserial[i][j]) {
					System.out.println("Incorrect!");
				}
			}
		}
		System.out.println("Correct!");
	}

	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}