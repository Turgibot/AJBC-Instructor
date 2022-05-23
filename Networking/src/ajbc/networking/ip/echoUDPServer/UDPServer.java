package ajbc.networking.ip.echoUDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	private final int INPUT_BUFFER_SIZE = 1024;
	private final int OUTPUT_BUFFER_SIZE = 1024;
	private DatagramSocket serverSocket;
	private int serverPort;

	public UDPServer(int serverPort) throws SocketException {
		this.serverPort = serverPort;
		serverSocket = new DatagramSocket(serverPort);
		System.out.println("[UDP Server] Datagram Socket started on port " + serverPort);
	}

	public void echoData() throws IOException {
		byte[] receiveData = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, INPUT_BUFFER_SIZE);
		System.out.println("[UDP Server] Waiting for incoming messages on port " + serverPort + " ...");
		while (true) {
			// wait for incoming packets

			serverSocket.receive(receivePacket);

			// Extract received packet data
			InetAddress clientIPAddress = receivePacket.getAddress();
			int clientPort = receivePacket.getPort();
			String msg = new String(receivePacket.getData()).trim();

			System.out.println("Received data from " + clientIPAddress);

			// send response back to the client host

			byte[] sendData = msg.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
			serverSocket.send(sendPacket);
		}
	}

	public static void main(String[] args) throws IOException {
		int port = 5555;
		UDPServer server = new UDPServer(port);
		server.echoData();
	}
}
