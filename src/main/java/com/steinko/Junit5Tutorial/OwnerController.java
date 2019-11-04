package com.steinko.Junit5Tutorial;

import java.util.List;

public class OwnerController {
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
	private OwnerService service;

	public OwnerController(OwnerService service) {
		this.service = service;
	}
	
	public String prosessFindForm(Owner owner, BindingResult result, Model model) {
		
		List<Owner> results = service.findAllByLastNameLike("%" + owner.getFamilyName() +  "%");
		
		if (results.isEmpty()) {
            
            return "owners/findOwners";
        } else if (results.size() == 1) {
            
            return "redirect:/owners/" + "5";
        }
		return null;
		
	}

	public String processCreateForm(Owner owner, BindingResult result) {
		if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            
            return "redirect:/owners/" + '5';
        }
	}

	

}
