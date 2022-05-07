package ajbc.patterns.builder.exe;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
	
	public void setName(String name);

	public void setMozzarellaCheese(int mozzarellaCheese);

	public void setFetaCheese(int fetaCheese);

	public void setMushroom(int mushroom);

	public void setPineapple(int pineapple);

}
