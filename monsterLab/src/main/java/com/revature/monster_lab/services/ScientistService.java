package com.revature.monster_lab.services;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.web.dto.ScientistRequest;
import com.revature.monster_lab.web.dto.ScientistResponse;


// THIS IS PURELY BUSINESS LOGIC
// WAT IT MEME?
// Business validation steps. Is what's been entered appropriate or valid? It might call checks to the DAO
// but never touch the database directly
@Service
public class ScientistService {

	private final ScientistDAO scientistDao;
	
	// DI - Dependency Injection of the DAO
	public ScientistService(ScientistDAO scientistDAO) {
		this.scientistDao = scientistDAO;
	}
	
	@Transactional
	public boolean registerNewScientist(ScientistRequest scientistRequest) {
		if(!isScientistValid(scientistRequest)) {
			throw new InvalidRequestException("Invalid user data provider");
		}
		
		Scientist newScientist = new Scientist(
				scientistRequest.getFirstName(), 
				scientistRequest.getLastName(),
				scientistRequest.getEmail(),
				scientistRequest.getUsername(),
				scientistRequest.getPassword()
				);

		boolean usernameAvailable = scientistDao.findByUsername(newScientist.getUsername()) == null;
		boolean emailAvailable = scientistDao.findByEmail(newScientist.getEmail()) == null;
		
		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			} else {
				throw new ResourcePersistenceException("The provided username and email were already taken in the database");
			}
		}
		newScientist.setScientistId(UUID.randomUUID().toString());
		newScientist.setAccountType(Scientist.AccountType.BASIC);
		Scientist persistedScientist = scientistDao.create(newScientist);
		
		if(persistedScientist == null) {
			throw new ResourcePersistenceException("The scientist could not be persisted");
		}
		
		return true;
	}
	
	// TODO: refactor to responses
	public List<ScientistResponse> getAllScientists(){
		return null;	
	}
	
	//TODO: Impelement authentication
	@Transactional(readOnly = true)
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

	public boolean isScientistValid(ScientistRequest newScientist) {
		if(newScientist == null) return false;
		if(newScientist.getFirstName() == null || newScientist.getFirstName().trim().equals("")) return false;
		if(newScientist.getLastName() == null || newScientist.getLastName().trim().equals("")) return false;
		if(newScientist.getEmail() == null || newScientist.getEmail().trim().equals("")) return false;
		if(newScientist.getUsername() == null || newScientist.getUsername().trim().equals("")) return false;
		return newScientist.getPassword() != null && !newScientist.getPassword().trim().equals("");


	}
	
}
