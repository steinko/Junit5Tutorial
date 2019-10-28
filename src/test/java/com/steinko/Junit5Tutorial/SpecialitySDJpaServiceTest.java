package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
public class SpecialitySDJpaServiceTest {
	
	@Mock
	SpecialityRepoitory repository;
	
	@InjectMocks
	SpecialitySDJpaService service;
	
	@Test
	void shouldDeleteById() {
		service.deletedById(1L);
		verify(repository).deletedById(1L);
		
	}
	
	@Test
	void shouldDelet() {
		service.delet(new Speciality());
		
	}

}
