package com.steinko.Junit5Tutorial.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class OwnerTest {
	
	@Test
	void shouldContainOwnerInformationDetails()  {
		Owner owner = new Owner(1L,"Torbjørn","Egner");
		owner.setCity("Bergen");
		owner.setTelephone(98675444);
		assertAll("Owner Detail Infromation Test",
				()->assertAll("Person detail information test",
				    ()->assertEquals("Torbjørn",owner.getFirstName()),
				    ()->assertEquals("Egner",owner.getFamilyName())),
		        ()->assertAll("Owner details information test",
		        	()->assertEquals(owner.getCity(),"Bergen"),
		        	()->assertEquals(owner.getTelephone(),98675444)
		        ));
				
	}

}
