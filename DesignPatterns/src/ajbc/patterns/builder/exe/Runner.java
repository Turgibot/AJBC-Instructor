package ajbc.patterns.builder.exe;

public class Runner {

	 public static void main(String[] args) {
	        Director director = new Director();

	        // Director gets the concrete builder object from the client
	        // (application code). That's because application knows better which
	        // builder to use to get a specific product.
	        PastryBuilder pastryBuilder = new PastryBuilder();
	        director.constructHawaiianPizza(pastryBuilder);;

	        // The final product is often retrieved from a builder object, since
	        // Director is not aware and not dependent on concrete builders and
	        // products.
	        Pastry hawaiianPizza = pastryBuilder.getResult();
	        System.out.println("Pastry created: " + hawaiianPizza.getName());

	        //construct dominican puff pastry
	        director.constructDominicanPuffPastry(pastryBuilder);
	        Pastry dominicanPuff = pastryBuilder.getResult();
	        System.out.println("Pastry created: " + dominicanPuff.getName());

	        
	        
	        RecipeBuilder recipeBuilder = new RecipeBuilder();

	        // Director may know several building recipes.
	        director.constructHawaiianPizza(recipeBuilder);
	        Recipe hawaiianPizzaRecipe = recipeBuilder.getResult();
	        System.out.println(hawaiianPizzaRecipe);
	        
	        director.constructDominicanPuffPastry(recipeBuilder);
	        Recipe dominicanPuffRecipe = recipeBuilder.getResult();
	        System.out.println(dominicanPuffRecipe);
	        
	        
	    }

}
