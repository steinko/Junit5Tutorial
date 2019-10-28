package com.steinko.Junit5Tutorial;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@WebMvcTest(IndexController.class)

public class IndexControllerTest {
	
	IndexController controller;
	
	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}
	
	
		
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnHelloWorld() throws Exception{ 
		RequestBuilder request = MockMvcRequestBuilders
				.get("/")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("index", result.getResponse().getContentAsString());
		
	}
	
	@Test 
	public void shouldReturnHelloWorld2() { 
		assertEquals("index",controller.index(),()-> "returned index");
		
	}
	
	
	@Test 
	public void shoulOpsHandler() { 
		assertThrows(HandelExeption.class,()-> controller.oupsHandler(),()-> "return exeption");
		
	}
	
	
}
