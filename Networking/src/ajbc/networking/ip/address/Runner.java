package ajbc.networking.ip.address;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Runner {
	public static void main(String args[]) throws UnknownHostException {

		// obtain the IP address of the localhost (the computer the program is running
		// on):
		InetAddress Address = InetAddress.getLocalHost();

		// print the InetAddress Object of localhost
		System.out.println("locahost InetAddress: " + Address);

		// print the address only
		System.out.println("locahost host address: " + Address.getHostAddress());
		// print the name only
		System.out.println("locahost host name: " + Address.getHostName());
		System.out.println("");

		// get the InetAddress for a String representation of an IP address
		Address = InetAddress.getByName("192.168.1.12");
		// print the address of the website
		System.out.println("localhost InetAddress: " + Address); // loopback

		System.out.println("");

		// find the IP address of a website
		Address = InetAddress.getByName("java.com");

		// print the address of the website
		System.out.println("java.com InetAddress: " + Address);

		System.out.println("");

		// get all IP address of a website
		InetAddress addresses[] = InetAddress.getAllByName("www.google.com");
		for (int i = 0; i < addresses.length; i++)
			System.out.println(addresses[i]);
	}
}
