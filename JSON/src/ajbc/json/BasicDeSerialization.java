package ajbc.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * using GSON library to de-serialize a string to a User POJO class
 * 
 * @author Guy Tordjman
 *
 */
public class BasicDeSerialization {

	public static void run() {
		File file = new File(Path.of("myFiles", "user.json").toString());
		try (FileReader fileReader = new FileReader(file)) {

			JsonReader jsonReader = new JsonReader(fileReader);

			Gson gson = new Gson();
			User user = gson.fromJson(jsonReader, User.class);
			System.out.println(user);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
