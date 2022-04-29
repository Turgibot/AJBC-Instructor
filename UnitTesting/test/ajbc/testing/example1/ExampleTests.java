package ajbc.testing.example1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples for learning junit")
class ExampleTests {
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
	
	@Test
//	@Disabled
	void checkObjNum() {
		assertNotNull(null, "object is null");
		assertEquals(1, 0, "1 is not zero");
	}
	
	@Test
	void exceptionIsThrown() {
		assertThrows(IOException.class, ()->throwException());
	}
	
	void throwException() throws IOException{
		throw new IOException();
	}
}
