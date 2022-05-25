package ajbc.networking.ip.echoUDPClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private InetAddress localInetAddress;
	private InetAddress serverInetAddress;
	private String serverName;
	private int serverPort;
	private int localPort;
	private DatagramSocket clientSocket;
	private Scanner sc;
	private final int INPUT_BUFFER_SIZE = 1024;

	public Client(String serverName, int serverPort, int localPort) throws SocketException, UnknownHostException {
		this.localPort = localPort;
		this.serverName = serverName;
		this.serverPort = serverPort;

		clientSocket = new DatagramSocket(localPort);
		sc = new Scanner(System.in);
		serverInetAddress = InetAddress.getByName(serverName);
		localInetAddress = InetAddress.getLocalHost();
	}

	public void sendData() {
		Thread thread = new Thread(() -> {
			while (true) {
				try {

					System.out.println("Enter a message");
					String msg = sc.nextLine();
					if (msg.toLowerCase().equals("quit")) {
						break;
					}
					byte[] msgBytes = msg.getBytes();
					DatagramPacket packet = new DatagramPacket(msgBytes, msgBytes.length, localInetAddress, serverPort);
					clientSocket.send(packet);
					Thread.sleep(1000);
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		thread.start();
	}

	public void receiveData() {
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					byte[] inputBuffer = new byte[INPUT_BUFFER_SIZE];
					DatagramPacket receivePacket = new DatagramPacket(inputBuffer, INPUT_BUFFER_SIZE);
					clientSocket.receive(receivePacket);
					String msg = new String(receivePacket.getData()).trim();
					System.out.println("[SERVER] "+msg);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});
		thread.start();
	}
	
	public static void main(String[] args) throws SocketException, UnknownHostException {
		String serverName = "localHost";
		int serverPort = 5555;
		int localPort = 5554;
		Client client = new Client(serverName, serverPort, localPort);
		client.receiveData();
		client.sendData();
	}
}
