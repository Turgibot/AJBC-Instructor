package ajbc.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
/**
 * using GSON library to serialize a User POJO class 
 * @author Guy Tordjman
 *
 */
public class BasicSerialization {

	public static void run() {

		User user = new User("Guy Tordjman", "turgibot@gmail.com", 33, true);
		Gson gson = new Gson();
		String userJson = gson.toJson(user);
		System.out.println(userJson);
		File file = new File("myFiles/user.json");
		try (FileWriter writer = new FileWriter(file)){
			writer.write(userJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
