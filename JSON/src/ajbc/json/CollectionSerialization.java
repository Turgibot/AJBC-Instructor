package ajbc.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
/**
 * using GSON library to serialize a Nested class 
 * @author Guy Tordjman
 *
 */
public class CollectionSerialization {

	public static void run() {
		
		Address address1 = new Address("Hawaii", "Honolulu");
		Address address2 = new Address("New York", "New York");
		Address address3 = new Address("Florida", "Miami");
		
		Address[] addArray = {address1,address2,address3};
		List<Address>addList = Arrays.asList(addArray);
		
		Gson gson = new Gson();
		String addArrJson = gson.toJson(addArray);
		String addListJson = gson.toJson(addList);
		System.out.println(addArrJson);
		System.out.println(addListJson);
		File arrayFile = new File("myFiles/addArray.json");
		File listFile = new File("myFiles/addList.json");
		try (FileWriter arrayWriter = new FileWriter(arrayFile);
				FileWriter listWriter = new FileWriter(listFile)){
			arrayWriter.write(addArrJson);
			listWriter.write(addListJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
