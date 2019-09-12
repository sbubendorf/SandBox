package ch.rusi.sandbox.lombok;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lombok Tutorial Tests")
public class PersonTest {

	@Test
	@DisplayName("Create Person")
	public void createPersonTest() {
		Person person = new Person();
		person.setFirstName("Simon");
		person.setLastName("Bubendorf");
		person.setStreet("Drosselstrasse 29");
		person.setZip("4106");
		person.setCity("Therwil");
		person.setEmployed(true);
		person.setYearBirth(1969);
		System.out.println(person);
		assertNotNull(person);
	}

 
}
