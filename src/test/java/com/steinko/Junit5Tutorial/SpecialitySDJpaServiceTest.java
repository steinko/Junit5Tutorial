package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;





@ExtendWith(MockitoExtension.class)
public class SpecialitySDJpaServiceTest {
	
	@Mock
	SpecialityRepoitory repository;
	
	@InjectMocks
	SpecialitySDJpaService service;
	
	@Test
	void shouldreturnSpecalityObject() {
		Speciality speciality = new Speciality();
		when(service.findById(1L)).thenReturn(speciality);
        Speciality found = service.findById(1L);
        assertEquals(speciality,found);
	}
	
	@Test
	void shouldDeleteById() {
		service.deletedById(1L);
		verify(repository).deletedById(1L);
		
	}
	
	
	
	@Test
	void shouldDelet() {
		service.delet(new Speciality());
		verify(repository).delete(any(Speciality.class));
		
	}

}
