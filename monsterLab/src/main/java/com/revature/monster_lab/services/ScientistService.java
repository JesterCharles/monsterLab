package com.revature.monster_lab.services;

import java.io.File;
import java.io.FileWriter;

import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.collections.List;

public class ScientistService {

	private final ScientistDAO scientistDao;
	
	public ScientistService(ScientistDAO scientistDAO) {
		this.scientistDao = scientistDAO;
	}
	
	public Scientist registerNewScientist(Scientist newScientist) {
		if(!isScientistValid(newScientist)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

		// TODO: Write logic that verifies the new users information isn't duplicated int he system
		Scientist persistedScientist = scientistDao.create(newScientist);
		
		if(persistedScientist == null) {
			throw new ResourcePersistenceException("The scientist could not be persisted");
		}
		
		return persistedScientist;
	}
	
	public List<Scientist> getAllScientists(){
		return scientistDao.findAll();	
	}
	
	//TODO: Impelement authentication
	public Scientist authenticateScientist(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		Scientist authenticatedScientist = scientistDao.findByUsernameAndPassword(username, password);
		
		if(authenticatedScientist == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		return authenticatedScientist;
	}

	public boolean isScientistValid(Scientist newScientist) {
		if(newScientist == null) return false;
		if(newScientist.getFirstName() == null || newScientist.getFirstName().trim().equals("")) return false;
		if(newScientist.getLastName() == null || newScientist.getLastName().trim().equals("")) return false;
		if(newScientist.getEmail() == null || newScientist.getEmail().trim().equals("")) return false;
		if(newScientist.getUsername() == null || newScientist.getUsername().trim().equals("")) return false;
		return newScientist.getPassword() != null || !newScientist.getPassword().trim().equals("");


	}
	
}
