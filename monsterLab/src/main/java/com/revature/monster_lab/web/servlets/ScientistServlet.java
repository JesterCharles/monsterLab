package com.revature.monster_lab.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.web.dto.ScientistRequest;

@RestController
@RequestMapping("/scientists")
public class ScientistServlet {
	
	private final ScientistService scientistService;
	
	@Autowired
	public ScientistServlet(ScientistService scientistService) {
		this.scientistService = scientistService;
	}
	
	@PostMapping
	public void createScientist(@RequestBody ScientistRequest scientistRequest) {
		scientistService.registerNewScientist(scientistRequest);
	}
}
