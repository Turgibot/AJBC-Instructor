package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFood {

	@Test
	void testIsDesert() {
		Food food1 = new Food("Meat", Taste.Salty, Macronutrient.Protein);
		assertFalse(food1.isDesert());
		Food food2 = new Food("Cake", Taste.Sweet, Macronutrient.CarboHydrate);
		assertTrue(food2.isDesert());
		Food food3 = new Food("Milkshake", Taste.Sweet, Macronutrient.Fat);
		assertFalse(food3.isDesert());
		Food food4 = new Food("Bun", Taste.Salty, Macronutrient.CarboHydrate);
		assertFalse(food4.isDesert());

	}

	@Test
	void testSetName()
	{
		String originalName = "Meat";
		Food food1 = new Food(originalName, Taste.Salty, Macronutrient.Protein);
		
		assertThrows(NonCapitalizedException.class, ()->food1.setName(""));
		assertEquals(originalName, food1.name);
		
		assertThrows(NonCapitalizedException.class, ()->food1.setName("a"));
		assertEquals(originalName, food1.name);
		
		assertThrows(NonCapitalizedException.class, ()->food1.setName(null));
		assertEquals(originalName, food1.name);

		assertDoesNotThrow(() -> food1.setName("Fries"));
		assertEquals("Fries", food1.name);
		
		assertDoesNotThrow(() -> food1.setName("C"));
		assertEquals("C", food1.name);
		
	}
	
}
