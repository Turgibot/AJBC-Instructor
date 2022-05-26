package ajbc.networking.ip.TCPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;


public class Server{
private final static int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
	
		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		try {
		
			//start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port "+ PORT);
		
			while(true) {
				// 3 way handshake
				Socket clientSocket = serverSocket.accept();
				System.out.println("client is connected "+clientSocket.getInetAddress()+" port "+clientSocket.getPort());
				
				//create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				//reading data
				String line = bufferReader.readLine();
				System.out.println("client says: "+line);
				
				//sending data
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("I must have called a thousand times");
			}
		
		
		
		} catch (IOException e) {
			System.err.println("Failed to start server on port "+PORT);
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			if(bufferReader != null)
			bufferReader.close();
		}
		
		
		
	}

}
