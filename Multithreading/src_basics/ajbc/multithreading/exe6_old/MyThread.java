package ajbc.multithreading.exe6_old;

public class MyThread extends Thread{
	private int startRow;
	private int endRow;
	private double[][] matrix;
	
	public MyThread(int startRow, int endRow, double[][] matrix) {
		this.startRow = startRow;
		this.endRow = endRow;
		this.matrix = matrix;
	}


	@Override
	public void run() {
		for (int i = startRow; i < endRow; i++) {
			for (int j = 0; j < matrix[i].length ; j++) {
				matrix[i][j] = Math.random();
			}
		}
		
	}
	
}