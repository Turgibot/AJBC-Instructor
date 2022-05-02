package ajbc.testing.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ajbc.testing.calculator.Calculator.Operation;

@DisplayName("Calculator class tests")
class CalculatorTest {

	private final int CONSTRUCTOR1 = 2;

	private Calculator calculator1;

	public CalculatorTest() {
		calculator1 = new Calculator(2);
	}

	@Test
	@DisplayName("constructor1.answer should be " + CONSTRUCTOR1)
	void checkConstructor1() {
		int actual = calculator1.answer;
		int expected = CONSTRUCTOR1;
		assertEquals(expected, actual);

	}

	@Test
	void checkSum() {
		calculator1.sum(3, 5);
		assertEquals(8, calculator1.answer);
		assertFalse(calculator1.lastOperation == Operation.SUBTRACT);
	}

	@Test
	void checkOperation() {
		assertNull(calculator1.lastOperation);
	}

	@Test
	void checkArray() {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };

		assertArrayEquals(arr1, arr2);

	}

	@Test
	@Disabled
	void checkDivision() {
		assertDoesNotThrow(() -> calculator1.divide(10, 10));
		assertThrows(ArithmeticException.class, () -> calculator1.divide(10, 0));
	}

	@Test
	void checkDuration() {

		assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
			Thread.sleep(100);
			return 2;
		});
	}

}
