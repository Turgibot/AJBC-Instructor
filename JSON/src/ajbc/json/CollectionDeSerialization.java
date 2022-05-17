package ajbc.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

/**
 * using GSON library to de-serialize a string to a nested class
 * 
 * @author Guy Tordjman
 *
 */
public class CollectionDeSerialization {

	public static void run() {
		File file = new File(Path.of("myFiles", "addArray.json").toString());
		try (FileReader fileReader1 = new FileReader(file);
				FileReader fileReader2 = new FileReader(file)) {

			JsonReader jsonReader = new JsonReader(fileReader1);

			Gson gson = new Gson();
			
			//arrays are deserialized immediately
			Address[] addArray = gson.fromJson(jsonReader, Address[].class);
			
			
			
			
			for (Address address : addArray) {
				System.out.println(address);
			}
			
			
			
			
			
			
			//collections need TypeToken
			jsonReader = new JsonReader(fileReader2);
			Type addressListType = new TypeToken<ArrayList<Address>>(){}.getType();
			List<Address> addList = gson.fromJson(jsonReader,addressListType);
			System.out.println("==========================");
			addList.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
