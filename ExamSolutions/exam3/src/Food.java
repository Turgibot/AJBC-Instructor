package src;

import java.io.Serializable;

public class Food implements Serializable{
	
	protected String name;
	protected Taste taste;
	protected Macronutrient macronutrient;
	protected final String DEFAULT_NAME = "Food";
	
	public Food(String name, Taste taste, Macronutrient macronutrient) {
		try {
			setName(name);
		} catch (NonCapitalizedException e) {
			System.out.println(e);
			this.name = DEFAULT_NAME;
		}
		this.taste = taste;
		this.macronutrient = macronutrient;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", macronutrient=" + macronutrient + "]";
	}
	
	public boolean isDesert()
	{
		return taste == Taste.Sweet && macronutrient == Macronutrient.CarboHydrate;
	}

	public void setName(String name) throws NonCapitalizedException {
		if (name == null || name.length() == 0)
			throw new NonCapitalizedException();
		else
		{
			char firstLetter = name.charAt(0);
			if (!Character.isUpperCase(firstLetter))
				throw new NonCapitalizedException();
			this.name = name;
		}

	}
	
	
	

}
