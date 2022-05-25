package ajbc.networking.ip.echoUDPServerSimple;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * This is an implementation of a UDP server
 */
public class Server {

	private final static int INPUT_BUFFER_SIZE = 1024;
	private final static int OUTPUT_BUFFER_SIZE = 1024;
	
	public static void main(String[] args)  {
		int port = 4444;
		try {
			DatagramSocket serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port "+port);
			
			//handle data
			
			
			System.out.println("Server is listening on port "+port);
			
			//listening to clients
			
			while(true) {
				
				byte[] inputBuffer = new byte[INPUT_BUFFER_SIZE];
				DatagramPacket receivedPacket = new DatagramPacket(inputBuffer , INPUT_BUFFER_SIZE);
				//this is a blocking method
				serverSocket.receive(receivedPacket);
				
				//get client address info
				InetAddress clientAddress = receivedPacket.getAddress();
				int clientPort = receivedPacket.getPort();
				
				//get client msg
				String clientMsg = new String(receivedPacket.getData()).trim();
				
				//print client msg for debugging purpose
				System.out.println("client "+clientAddress+" sent: "+clientMsg);
				
				//prepare packet for sending
				byte[] myBytes = clientMsg.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);
				
				//send packet back to client
				serverSocket.send(packetToSend);
				System.out.println("Server echo response sent");
				
			}		
			
		} catch (SocketException e) {
			System.err.println("Server Connection failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
	}
}
