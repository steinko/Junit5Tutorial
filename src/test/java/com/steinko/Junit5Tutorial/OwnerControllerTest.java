package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
	
	@InjectMocks
	private OwnerController controller;
	
	@Mock
	private OwnerService service;
	
	@Mock
	private BindingResult result;
	
	private Owner owner;
	private List<Owner> owners;
	Model model;

	@BeforeEach
	void setUp() { 
		owner = new Owner(0L, null, null);
		owners = new ArrayList<Owner>();
	    model = new Model();
	}
	
	
	@Test
	void shouldExists() { 
		assertNotNull(controller);
	}
	
	
	@Test
	void sholdReturnOwnerFindOwner() {
		given(result.hasErrors()).willReturn(true);
		String viewForm = controller.processCreateForm(owner,result);
		assertEquals(viewForm,"owners/createOrUpdateOwnerForm");
	}	
	
	@Test
	void shouldReturnRedirectOwners5() { 
		String viewForm = controller.processCreateForm(owner,result);
		assertEquals(viewForm,"redirect:/owners/5");
	}
	
	@Test
	void shouldBeEmpty() { 
		List<Owner> owners = new ArrayList<Owner>();
		assertTrue(owners.isEmpty());
		
	}

}
