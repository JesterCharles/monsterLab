package com.revature.monster_lab.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.web.dto.LoginCredentials;

// @WebServlet, why don't we do this? Because we are going to define a constructor. 
public class AuthServlet extends HttpServlet{

	private final ScientistService scientistService;
	private final ObjectMapper mapper;
	
	public AuthServlet(ScientistService scientistService, ObjectMapper mapper) {
		this.scientistService = scientistService;
		this.mapper = mapper;
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try {
			LoginCredentials loginCreds = mapper.readValue(req.getInputStream(), LoginCredentials.class);
			Scientist authenticatedScientist = scientistService.authenticateScientist(loginCreds.getUsername(), loginCreds.getPassword());
			HttpSession httpSession = req.getSession(true);
			httpSession.setAttribute("authScientist", authenticatedScientist);
		} catch (InvalidRequestException | UnrecognizedPropertyException e) {
			// TODO: handle exception
			resp.setStatus(400);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			resp.setStatus(401);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.setStatus(500);
		}
		
	}
	
}
