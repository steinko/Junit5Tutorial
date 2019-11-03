package com.steinko.Junit5Tutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.RuntimeException;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.doThrow;
import static org.mockito.BDDMockito.willThrow;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;






@ExtendWith(MockitoExtension.class)
public class SpecialitySDJpaServiceTest {
	
	@Mock
	SpecialityRepoitory repository;
	
	@InjectMocks
	SpecialitySDJpaService service;
	
	@Test
	void shouldreturnSpecalityObject() {
		//Given
		Speciality speciality = new Speciality();
		given(service.findById(1L)).willReturn(speciality);
		//When
        Speciality found = service.findById(1L);
        //Then
        assertEquals(speciality,found);
        then(repository).should().findById(anyLong());
        then(repository).shouldHaveNoMoreInteractions();
	} 	
	
	@Test
	void shouldDeleteById() {
		service.deletedById(1L);
		then(repository).should().deletedById(1L);
		
	}
	
	
	
	@Test
	void shouldDelet() {
		service.delet(new Speciality());
		then(repository).should().delete(any(Speciality.class));
		
	}
	
	@Test
	void shouldTrowAnException () {
		doThrow(new RuntimeException("boom")).when(repository).delete(any());
		assertThrows(RuntimeException.class,()->repository.delete(new Speciality()));
		verify(repository).delete(any());
		
	}
	
	@Test
	void shouldThrowException2() {
		given(repository.findById(1L)).willThrow(new RuntimeException("boom"));
		assertThrows(RuntimeException.class, ()->service.findById(1L));
		then(repository).should().findById(1L);
	}
	
	@Test
	void shoudBeDeleted() {
		willThrow(new RuntimeException("boom")).given(repository).delete(any());
		assertThrows(RuntimeException.class, ()-> repository.delete(new Speciality()));
		then(repository).should().delete(any());
	}
	
	@Test
	void shouldSaveWithMatch() {
		final String MATCH_ME = "MATCH_ME";
		Speciality speciality = new Speciality();
		speciality.setDescription(MATCH_ME);
		
		Speciality saveSpeciality = new Speciality();
		saveSpeciality.setId(1L);
		//given(repository.save(argThat(argument->argument.getDescription().equals(MATCH_ME)))).willReturn(saveSpeciality);
		
		Speciality returnSpeciality = service.save(speciality);
		assertEquals(returnSpeciality.getId(),1L);
		
	}
	
	

}
