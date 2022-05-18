package src;
/**
 * Created by the student Rotem Levi
 * Thank you Rotem
 */
import java.time.LocalDate;

public class Runner {

	public static void main(String[] args) {
		
		Food food1 = new Food("Meat", Taste.Salty, Macronutrient.Protein);
		Food food2 = new Food("Cake", Taste.Sweet, Macronutrient.CarboHydrate);
		
		Dragon dragon1 = new Dragon("Dragonizer", LocalDate.of(800, 1, 1), 10);
		Dragon dragon2 = new Dragon("Dragon Ball", LocalDate.of(700, 1, 1), 1);

		Utils utils = new Utils();
		Object[] objects = {food1, food2, dragon1, dragon2};
		
		utils.writeRandomObjectToFile(objects);
		utils.writeRandomObjectToFile(objects);
		utils.readAndPrintObjectsFromFile();
		utils.closeResources();

	}

}
