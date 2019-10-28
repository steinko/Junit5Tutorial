package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


public class PersonTest {
	
	@Test
	void sholdStorePersonInformation() { 
		Person person = new Person(1L,"Stein", "Korsveien");
		assertAll("should deliver correct person information",
			()->assertEquals(person.id(),1L),
			()->assertEquals(person.getFirstName(),"Stein"),
			()->assertEquals(person.getFamilyName(),"Korsveien")
		);
		
	}
	

}
