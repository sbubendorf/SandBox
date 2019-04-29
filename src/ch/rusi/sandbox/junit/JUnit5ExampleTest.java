package ch.rusi.sandbox.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit 5 Example")
public class JUnit5ExampleTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// The method that is annotated with the @BeforeAll annotation must be static, and it’s run once before any test method is run.
		System.out.println("Before all test methods");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		// The method that is annotated with the @AfterAll annotation must be static, and it’s run once after all test methods have been run.
		System.out.println("After all test methods");
	}

	@BeforeEach
	public void setUp() throws Exception {
		// The method that is annotated with the @BeforeEach is invoked before each test method.
		System.out.println("Before each test method");
	}

	@AfterEach
	public void tearDown() throws Exception {
		// The method that is annotated with the @AfterEach annotation is invoked after each test method.
		System.out.println("After each test method");
	}

	@Test
	@DisplayName("First test method")
	public void firstTest() {
		System.out.println("First test method");
	}

	@Test
	@DisplayName("Second test method")
	public void secondTest() {
		System.out.println("Second test method");
	}

}
