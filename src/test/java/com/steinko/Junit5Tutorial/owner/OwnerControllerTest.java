package com.steinko.Junit5Tutorial.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

import com.steinko.Junit5Tutorial.BindingResult;
import com.steinko.Junit5Tutorial.Model;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
	
	@InjectMocks
	private OwnerController controller;
	
	@Mock
	private OwnerService service;
	
	@Mock
	private BindingResult result;
	
	Model model;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	
	
	@Test
	void shouldExists() { 
		assertNotNull(controller);
	}
	
	
	@Test
	void sholdReturnOwnerFindOwner() {
		Owner owner = new Owner(0L,null,null);
		
		given(result.hasErrors()).willReturn(true);
		String viewForm = controller.processCreateForm(owner,result);
		assertEquals(viewForm,"owners/createOrUpdateOwnerForm");
	}	
	
	@Test
	void shouldReturnRedirectOwners5() { 
		Owner owner = new Owner(0L,null,null);
		String viewForm = controller.processCreateForm(owner,result);
		assertEquals(viewForm,"redirect:/owners/5");
	}
	
	@Test
	void shouldBeEmpty() { 
		List<Owner> owners = new ArrayList<Owner>();
		assertTrue(owners.isEmpty());
		
	}
	
	@Nested
	class ViewTest { 
		
	  @BeforeEach
	  void setUp() { 
		  given(service.findAllByLastNameLike(stringArgumentCaptor.capture()))
	        .willAnswer(invocation -> {
	           List<Owner> owners = new ArrayList<>();
	           String name = invocation.getArgument(0);
	    		  if(name.equals("%Korsveien%")) { 
	    			owners.add(new Owner(0L, null, "Korsveien"));
	    			return owners;
	    		  } else if (name.equals("%Don't find me%"))
	    			  return owners;
	    		  else if (name.equals("%FindMe%")) {
	    			  owners.add(new Owner(2L,null,"Owner1"));
	    		      owners.add(new Owner(3L,null,"Owner2"));
	    			  return owners;
	    		  }
	    	     
	           throw new RuntimeException("Invalid Argument");
	     
	      });
		  
	  }
	
	   @Test
	   void shouldReturnRedirctOwners1() { 
		  Owner owner = new Owner(1L,null,"Korsveien");
		  String viewName = controller.prosessFindForm(owner, result, model);
		  assertEquals("%Korsveien%", stringArgumentCaptor.getValue());
		  assertEquals("redirect:/owners/1",viewName);
	   }
	   
	   @Test
	   void shouldReturnOwnersFindOwners() { 
		  Owner owner = new Owner(1L,null,"Don't find me");
		  String viewName = controller.prosessFindForm(owner, result, model);
		  assertEquals("owners/findOwners",viewName);
	   }
	   
	   @Test
	   void shouldReturnOwners() { 
		  Owner owner = new Owner(1L,null,"FindMe");
		  String viewName = controller.prosessFindForm(owner, result, model);
		  assertEquals("owners/ownersList",viewName);
	   }
	
	}
	
}
