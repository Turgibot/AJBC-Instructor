package ajbc.patterns.builder.exe;
/**
 * Car is a product class.
 */
public class Pastry {
	private final String name;
	private final int mozzarellaCheese;
    private final int fetaCheese;
    private final int mushroom;
    private final int pineapple;
    
	public Pastry(String name, int mozzarellaCheese, int fetaCheese, int mushroom, int pineapple) {
		this.name = name;
		this.mozzarellaCheese = mozzarellaCheese;
		this.fetaCheese = fetaCheese;
		this.mushroom = mushroom;
		this.pineapple = pineapple;
	}
	@Override
	public String toString() {
		return "Pizza [name=" + name + ", mozzarellaCheese=" + mozzarellaCheese + ", fetaCheese=" + fetaCheese
				+ ", mushroom=" + mushroom + ", pineapple=" + pineapple + "]";
	}
	
	public String getName() {
		return name;
	}
    
	
    
}