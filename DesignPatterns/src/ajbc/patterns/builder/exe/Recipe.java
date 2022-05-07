package ajbc.patterns.builder.exe;

/**
 * Car manual is another product. Note that it does not have the same ancestor
 * as a Car. They are not related.
 */
public class Recipe {
	private final String name;
    private final int mozzarellaCheese;
    private final int fetaCheese;
    private final int mushroom;
    private final int pineapple;
   
    

    public Recipe(String name, int mozzarellaCheese, int fetaCheese, int mushroom, int pineapple) {
		this.name = name;
    	this.mozzarellaCheese = mozzarellaCheese;
		this.fetaCheese = fetaCheese;
		this.mushroom = mushroom;
		this.pineapple = pineapple;
	}



	@Override
	public String toString() {
		return "Recipe [name=" + name + ", mozzarellaCheese=" + mozzarellaCheese + ", fetaCheese=" + fetaCheese
				+ ", mushroom=" + mushroom + ", pineapple=" + pineapple + "]";
	}





    
}