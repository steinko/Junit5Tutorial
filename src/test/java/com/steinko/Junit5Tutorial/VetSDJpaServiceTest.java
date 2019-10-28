package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class VetSDJpaServiceTest {
	
	@Mock
	VetRepository repository;
	
	@InjectMocks
	VetSDJpaService service;
	
	@Test
	void shouldDeleteById() {
		service.deleteById(1L);
		verify(repository).deleteById(1L);
		
	}

}
