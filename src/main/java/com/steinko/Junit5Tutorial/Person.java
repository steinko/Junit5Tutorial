package com.steinko.Junit5Tutorial;

public class Person {
	
	private String firstName;
	private String familyName;
	private long id;

	public Person(long id, String firstName, String familyName) {
		this.id=id;
		this.firstName=firstName;
		this.familyName = familyName;
	}

	public Long id() {
		return 1L;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getFamilyName() {
		return familyName;
	}}
