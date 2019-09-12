package ch.rusi.sandbox.lombok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Family Tests")
public class FamilyTest {
	
	@Test
	@DisplayName("Create Family with one member")
	public void testFamilyWithOnlyOneMember() {
		Person person = Person.builder()
				.lastName("Meier")
				.firstName("Hans")
				.street("Hauptstrasse 44")
				.zip("4444")
				.city("Basel").build();
		System.out.println("Building Family with only " + person);
		Family fam = new Family(Arrays.asList(person));
		assertEquals(fam.getMembers().size(), 1);
	}
	
	@Test
	@DisplayName("Create Family with empty person list")
	public void testFamilyWithEmptyPersonList() {
		List<Person> familyMembers = null;
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Family fam = new Family(familyMembers);
		});
	}

}
