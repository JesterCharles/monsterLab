package com.revature.monster_lab.web.servlets;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.web.dto.LoginCredentials;

// @WebServlet, why don't we do this? Because we are going to define a constructor.

@RestController
@RequestMapping("/auth")
public class AuthServlet{

	private final ScientistService scientistService;
	
	@Autowired
	public AuthServlet(ScientistService scientistService) {
		this.scientistService = scientistService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void verifyScientist(@RequestBody LoginCredentials loginCredentials, HttpSession httpSession) {
		Scientist authScientist =  scientistService.authenticateScientist(loginCredentials.getUsername(), loginCredentials.getPassword());
		httpSession.setAttribute("authScientist", authScientist);
	}
	
	@DeleteMapping
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
