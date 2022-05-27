package ajbc.networking.game.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiClient {

	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8080, NUM_PLAYERS = 10;

	public static void main(String[] args) throws IOException, InterruptedException {

		ExecutorService clientsService = Executors.newFixedThreadPool(NUM_PLAYERS);
		CountDownLatch latch = new CountDownLatch(NUM_PLAYERS-1);
		for (int i = 0; i < NUM_PLAYERS; i++) {
			clientsService.execute(new Player(i, latch));
		}
		clientsService.shutdown();
		clientsService.awaitTermination(20, TimeUnit.SECONDS);
	}
	
	public static class Player implements Runnable{
		int num;
		CountDownLatch latch ;
		public Player(int num, CountDownLatch latch) {
			this.num= num;
			this.latch = latch;
		}
		@Override
		public void run() {
			Socket clientSocket = null;
			PrintWriter writer = null;
			BufferedReader bufferReader = null;

			try {
				latch.countDown();
				clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
				System.out.println("Connected to server");

				// sending data
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("Player %d sent request".formatted(num));

				// starting counter
				long start = System.currentTimeMillis();

				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				// reading data
				String line = bufferReader.readLine();

				// ending counter
				long end = System.currentTimeMillis();
				System.out.println("server says: " + line + "after " + (end - start) + " [ms].");

			} catch (UnknownHostException e) {
				System.err.println("Server is not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Socket failed");
				e.printStackTrace();
			} finally {
				if (clientSocket != null)
					try {
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (writer != null)
					writer.close();
				if (bufferReader != null)
					writer.close();
			}

		}
	};
}
