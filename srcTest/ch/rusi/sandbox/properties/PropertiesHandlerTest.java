package ch.rusi.sandbox.properties;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertiesHandlerTest {
	
	private String fileName = "config/test.properties";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWriteProperties() {
		writeTestProperties();
		Properties prop = PropertiesHandler.getInstance(fileName).getProperties();
		assertEquals(3, prop.keySet().size());
	}
	
	@Test
	void testHandlerWithoutProperties() {
		assertThrows(NullPointerException.class, () -> {
			PropertiesHandler.getInstance(null).getProperties();
		});
	}
	
	private void writeTestProperties() {
		PropertiesHandler ph = PropertiesHandler.getInstance(fileName);
		ph.setProperty("db.url", "ora1server:1521:databasename");
		ph.setProperty("db.user", "B040910");
		ph.setProperty("db.password", "pwd4simon");
		ph.writeProperties();
	}
	
}
