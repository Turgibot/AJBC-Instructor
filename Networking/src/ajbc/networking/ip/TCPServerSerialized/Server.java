package ajbc.networking.ip.TCPServerSerialized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;

import ajbc.networking.DB.Student;
import ajbc.networking.DB.StudentDB;


public class Server{
private final static int PORT = 8087;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
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
				int id  = Integer.parseInt(bufferReader.readLine());
				System.out.println("Student id: "+id);
				
				//getting student from db
				
				Student student = StudentDB.getStudentById(id);
				
				//sending data
	            ObjectOutputStream objectStream = new ObjectOutputStream(clientSocket.getOutputStream());
	            objectStream.writeObject(student);
	            
				//using json
//	            Gson gson = new Gson();
//		        String jsonStudent = gson.toJson(student);
//		        writer = new PrintWriter(clientSocket.getOutputStream(), true);
//		        writer.println(jsonStudent);
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
