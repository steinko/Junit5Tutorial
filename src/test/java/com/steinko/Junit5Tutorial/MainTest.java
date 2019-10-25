package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MainTest {
	
	@Test
	void shouldBeLoaded() { 
		String[] args = {""};
		Main.main(args);
		
	}

}
