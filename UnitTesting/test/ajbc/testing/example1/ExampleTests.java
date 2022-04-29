package ajbc.testing.example1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExampleTests {
	Book b ;
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void checkIfNumbersEqual() {
		assertEquals(3, 3);
	}

	@Test
	void checkSum() {
		assertTrue(true, "The optional assertion message ");
		assertFalse(true);
	}
	
	class Book{
		int num;
	}
	
	@Test
//	@Disabled
	void checkBookNum() {
		assertNotNull(b, "Book b is null");
		assertEquals(b.num, 0, "Book num is not zero");
	}
}
