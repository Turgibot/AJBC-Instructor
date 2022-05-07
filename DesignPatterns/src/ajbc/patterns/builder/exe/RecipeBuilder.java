package ajbc.patterns.builder.exe;

/**
 * Unlike other creational patterns, Builder can construct unrelated products,
 * which don't have the common interface.
 *
 * In this case we build a user manual for a car, using the same steps as we
 * built a car. This allows to produce manuals for specific car models,
 * configured with different features.
 */
public class RecipeBuilder implements Builder{
	private String name;
	private int mozzarellaCheese;
	private int fetaCheese;
	private int mushroom;
	private int pineapple;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setMozzarellaCheese(int mozzarellaCheese) {
		this.mozzarellaCheese = mozzarellaCheese;
	}

	@Override
	public void setFetaCheese(int fetaCheese) {
		this.fetaCheese = fetaCheese;
	}
	@Override
	public void setMushroom(int mushroom) {
		this.mushroom = mushroom;
	}
	@Override
	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;
	}

	public Recipe getResult() {
        return new Recipe(name, mozzarellaCheese, fetaCheese, mushroom, pineapple);
    }


}