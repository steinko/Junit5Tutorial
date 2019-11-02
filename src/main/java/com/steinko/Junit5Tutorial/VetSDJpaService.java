package com.steinko.Junit5Tutorial;

import java.util.Set;

public class VetSDJpaService {
	
	VetRepository repository;
	
	VetSDJpaService(VetRepository repository )  {
		this.repository = repository;;
	}

	public void deleteById(long id) {
		
		repository.deleteById(id);
	}

	public Set<Visit> findAll() {
		
		return repository.findAll();
	}
	
	public Visit findById(long Id) {
		return repository.findById(Id);
	}

	public void save(Visit visit) {
		repository.save(visit);
		
	}

	public void delete(Visit visit) {
		repository.delete(visit);
		
		
	}

}
