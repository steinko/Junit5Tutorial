package com.steinko.Junit5Tutorial;

public class VetSDJpaService {
	
	VetRepository repository;
	
	VetSDJpaService(VetRepository repository )  {
		this.repository = repository;;
	}

	public void deleteById(long id) {
		
		repository.deleteById(id);
	}

}
