package ajbc.patterns.builder.exe;

/**
 * Concrete builders implement steps defined in the common interface.
 */
public class PastryBuilder implements Builder {
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

	public Pastry getResult() {
		return new Pastry(name, mozzarellaCheese, fetaCheese, mushroom, pineapple);
	}

}
