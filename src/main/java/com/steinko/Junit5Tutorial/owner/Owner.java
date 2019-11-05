package com.steinko.Junit5Tutorial.owner;

import com.steinko.Junit5Tutorial.Person;

public class Owner extends Person{
	  private String city;
	  private int telephone;

	public Owner(long id, String fistName, String familyName) {
		super(id, fistName, familyName);
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	

}
