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
		repository.delete(speciality);
	}

	public Speciality findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
