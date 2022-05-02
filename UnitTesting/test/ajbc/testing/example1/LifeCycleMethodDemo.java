package ajbc.testing.example1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)

public class LifeCycleMethodDemo {

	private int x;
	private int y;
	private static String str = "Setting static vars";
	
	@BeforeAll
	public static void resetValues() {
		System.out.println("Before starting to test anything...");
		System.out.println(str);
	}
	
	public LifeCycleMethodDemo() {
		System.out.println("An instance is prepared for each test");
	}
	
	
	
	@BeforeEach
	public void beforeTesting() {
		System.out.println("We can do something before each test");
		System.out.println("Before reset x = %d y = %d".formatted(x,y));
		x = 10;
		y = 10;
		System.out.println("After reset x = %d y = %d".formatted(x,y));
	}
	
	@Test
	public void test1() {
		x+=8;
		y-=1;
		System.out.println("Test1");
		
	}
	
	@Test
	public void test2(){
		y++;
		x--;
		System.out.println("Test2");
	}
	
	@AfterEach
	public void publish() {
		System.out.println("When test finished x = %d y = %d".formatted(x,y));
	}
	
	@AfterAll
	public static void theEnd() {
		System.out.println("That's it - all test are over");
	}
	
	
}
