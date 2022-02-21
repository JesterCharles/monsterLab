package com.revature.monster_lab.web.servlets;

import com.revature.monster_lab.services.ScientistService;

// @WebServlet, why don't we do this? Because we are going to define a constructor.

public class AuthServlet{

	private final ScientistService scientistService;
	
	public AuthServlet(ScientistService scientistService) {
		this.scientistService = scientistService;
	}
	
	
}
