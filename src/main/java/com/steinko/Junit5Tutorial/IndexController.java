package com.steinko.Junit5Tutorial;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}

	public String oupsHandler() {
		// TODO Auto-generated method stub
		 throw  new HandelExeption();
	}

}
