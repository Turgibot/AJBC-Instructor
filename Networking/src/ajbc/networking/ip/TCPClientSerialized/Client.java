package ajbc.networking.ip.TCPClientSerialized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import ajbc.networking.DB.Student;

public class Client {

	private final static String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8087;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket clientSocket = null;
		PrintWriter writer = null;
		BufferedReader bufferReader = null;
		ObjectInputStream objectInStream = null;
		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");

			// sending data
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println("1000");

			
			//reading serialized java object
			
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            Student student =(Student) (ois.readObject());
			
			
			// reading data from json
//
//			bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//			String msg = bufferReader.readLine();
//			Gson gson = new Gson();
//			Student student = gson.fromJson(msg, Student.class);

			System.out.println("student message received from client: \n" + student);

		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed");
			e.printStackTrace();
		} finally {
			if (clientSocket != null)
				clientSocket.close();
			if (writer != null)
				writer.close();
			if (bufferReader != null)
				writer.close();
		}

	}
}
