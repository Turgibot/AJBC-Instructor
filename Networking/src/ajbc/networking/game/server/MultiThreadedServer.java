package ajbc.networking.game.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedServer {
	private static final int PORT = 8080;

	public static void main(String[] args)  throws InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();
		
		try (ServerSocket serverSocket = new ServerSocket(PORT);) {

			System.out.println("Game Server started on port " + PORT);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				executorService.execute(new PlayerRunnable(clientSocket));
			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		}finally {
			executorService.shutdown();
			executorService.awaitTermination(2, TimeUnit.SECONDS);
		}

	}

	private static class PlayerRunnable implements Runnable {

		private Socket clientSocket;
		public PlayerRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			
			try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
								
				System.out.println(
						"Player is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());
				// reading data
				String line = bufferReader.readLine();
				System.out.println("Player says: " + line);
				
				// processing data simulation
				processData();
				
				// sending data
				writer.println("processing result done after ");
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

	private static void processData() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
