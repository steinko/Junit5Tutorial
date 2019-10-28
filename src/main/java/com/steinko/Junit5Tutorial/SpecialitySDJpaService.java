package com.steinko.Junit5Tutorial;

public class SpecialitySDJpaService {
	    private SpecialityRepoitory repository;
	    public SpecialitySDJpaService() { 
	    	repository = new SpecialityRepoitory();
	    }

	public void deletedById(long id) {
		repository.deletedById(id);
	}

	public void delet(Speciality speciality) {
		// TODO Auto-generated method stub
		
	}

}
