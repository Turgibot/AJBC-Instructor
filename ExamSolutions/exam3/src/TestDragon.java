package src;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestDragon {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetBirthDate() {
		
		LocalDate originalDate = LocalDate.of(800, 1, 1);
		Dragon dragon = new Dragon("Dragonizer",originalDate, 10);
		
		assertThrows(TooYoungException.class, ()-> dragon.setBirthDate(LocalDate.of(888, 8, 9)));
		assertEquals(originalDate, dragon.birthDate);
		
		assertThrows(TooYoungException.class, ()-> dragon.setBirthDate(LocalDate.of(1000, 8, 9)));
		assertEquals(originalDate, dragon.birthDate);
		
		assertDoesNotThrow(()-> dragon.setBirthDate(dragon.maxBirthDate));
		assertEquals(dragon.maxBirthDate, dragon.birthDate);
		
		LocalDate legitDate = LocalDate.of(820, 1, 1);
		assertDoesNotThrow(()-> dragon.setBirthDate(legitDate));
		assertEquals(legitDate, dragon.birthDate);

	}

}
