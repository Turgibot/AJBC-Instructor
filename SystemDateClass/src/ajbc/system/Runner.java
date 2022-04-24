package ajbc.system;

import java.sql.Date;
import java.util.Iterator;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) {
		
		//1. show output stream
		int y = 0;
		if (y == 0) {
			System.err.println("Error you are dividing by Zero");
		}
		System.out.println("Normal output is white");
		
		
		//2. Java platform system properties show keys
		Properties properties = System.getProperties();
		for (String property : properties.stringPropertyNames()) {
			System.out.println(property);
		}
		
		//3. get value of system property
		String key = "java.vendor";
		System.out.println(key+":"+System.getProperty(key));
		
		//return a default value if key doesn't exist
		
		key = "Guy.T";
		System.out.println(key+":"+System.getProperty(key, "Instructor"));
		
		
		//4. modify system properties

		key = "user.name";
		
		String value1 = System.getProperty(key, "Instructor");
		
		System.out.println(key+":"+value1);
		
		String value2 = "John Travolta";
		System.setProperty(key, value2);
		
		System.out.println(key+":"+System.getProperty(key, "Instructor"));
		
		System.setProperty(key, value1);
		
		//5. add system property
		
		key = "user.email";
		value1 = "turgibot@gmail.com";
		
		System.setProperty(key, value1);
		System.out.println(key+":"+System.getProperty(key, "Instructor"));
		
		
		//6. OS environment vars 
		
		for (String envKey : System.getenv().keySet()) {
			System.out.println("------------------");
			System.out.println(envKey+":"+System.getenv(envKey));
		}
		
		//7. current time in ms
		
		long time = System.currentTimeMillis();
		System.out.println("time in ms: "+time);
		
		//convert to Date obj
		System.out.println("ms as Date input: "+ new Date(time).toLocaleString());
		
		//8. array copy
		
		int[] src = {1,2,3,4,5,6,7};
		int[] dest = {9, 8, 7, 6};
		
		System.arraycopy(src, 2, dest, 1, 2);
		for (int i : dest) {
			System.out.print(i+", ");
		}
		
	}

}
