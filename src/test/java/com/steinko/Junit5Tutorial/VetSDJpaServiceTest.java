package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.*;



import static org.mockito.Mockito.when;

import static org.mockito.Matchers.anyLong;

import java.util.HashSet;
import java.util.Set;


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
	
	@Test
	void shouldDelete() {
		Visit visit = new Visit();
		service.delete(visit);
		verify(repository).delete(visit);
		
	}
	
	@Test 
	
	void shouldReturnAllVisists() { 
		Set<Visit> visits = new HashSet<Visit>();
		visits.add(new Visit());
		visits.add(new Visit());
		
		when(repository.findAll()).thenReturn(visits);
		Set<Visit> found = service.findAll();
		verify(repository).findAll();
		assertEquals(visits,found);
	}
	
	@Test
	void shouldReturnAVist() { 
		Visit visit = new Visit();
		when(repository.findById(anyLong())).thenReturn(visit);
		Visit found = service.findById(1L);
		assertEquals(visit,found);
	}
	
	@Test
	void shuldReturnAVisitBDD() { 
		Visit visit = new Visit();
		given(repository.findById(1L)).willReturn(visit);
		Visit found = service.findById(1L);
		then(repository).should(times(1)).findById(anyLong());
		then(repository).shouldHaveNoMoreInteractions();
		assertEquals(visit,found);
;	}
	
	@Test
	void shouldStoreAVisit() { 
		Visit visit = new Visit();
		service.save(visit);
		verify(repository).save(visit);
		
	}

}
