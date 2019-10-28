package com.steinko.Junit5Tutorial;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;

public class MockTest {
	
	@Mock
	Map<String,Object> mapMock;
	
	@BeforeEach
	void setUp() { 
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testMoc()  { 
		mapMock.put("keyvalue","foo");
	}
	
	@Test
	void innlineMock() {  
		Map mock = mock(Map.class);
		assertEquals(mock.size(),0);
	}

}
