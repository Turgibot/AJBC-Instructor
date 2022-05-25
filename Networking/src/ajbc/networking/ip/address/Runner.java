package ajbc.networking.ip.address;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Runner {

	public static void main(String[] args) throws UnknownHostException {
		// obtain the ip of your own computer
		InetAddress myAddress = InetAddress.getLocalHost();
		System.out.println(myAddress);

		// obtain ip and name as Strings
		String myIP = myAddress.getHostAddress();
		String myHostName = myAddress.getHostName();

		System.out.println("My ip %s and my name %s".formatted(myIP, myHostName));

		// get InetAddress from name

		InetAddress queryByHostNameAddress = InetAddress.getByName(myHostName);
		System.out.println(queryByHostNameAddress);

		// get InetAddress from ip
		InetAddress queryByHostIPAddress = InetAddress.getByName(myIP);
		System.out.println(queryByHostIPAddress);

		// get InetAddress from webpage name
		InetAddress queryByWebsiteAddress = InetAddress.getByName("google.com");
		System.out.println(queryByWebsiteAddress);

		// get all addresses of server

		InetAddress[] addresses = InetAddress.getAllByName("google.com");
		System.out.println(Arrays.toString(addresses));

		// loopback address

		InetAddress myLoop = InetAddress.getLoopbackAddress();
		System.out.println(myLoop);

	}

}
