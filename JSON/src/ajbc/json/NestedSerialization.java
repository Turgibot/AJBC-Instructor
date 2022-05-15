package ajbc.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
/**
 * using GSON library to serialize a Nested class 
 * @author Guy Tordjman
 *
 */
public class NestedSerialization {

	public static void run() {

		Address address = new Address("Hawaii", "Honolulu");
		Employee employee = new Employee("Guy Tordjman",33, "turgibot@gmail.com", address);
		
		Gson gson = new Gson();
		String empJson = gson.toJson(employee);
		System.out.println(empJson);
		File file = new File("myFiles/employee.json");
		try (FileWriter writer = new FileWriter(file)){
			writer.write(empJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
