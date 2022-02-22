package com.revature.monster_lab.services;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourceNotFoundException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.web.dto.ScientistRequest;
import com.revature.monster_lab.web.dto.ScientistResponse;
import com.revature.monster_lab.web.dto.UpdateScienitstRequest;


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
//		if(!isScientistValid(scientistRequest)) {
//			throw new InvalidRequestException("Invalid user data provider");
//		}
		
		Scientist newScientist = new Scientist(
				scientistRequest.getFirstName(), 
				scientistRequest.getLastName(),
				scientistRequest.getEmail(),
				scientistRequest.getUsername(),
				scientistRequest.getPassword()
				);

		boolean usernameAvailable = scientistDao.findScientistByUsername(newScientist.getUsername()) == null;
		boolean emailAvailable = scientistDao.findScientistByEmail(newScientist.getEmail()) == null;
		
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
		Scientist persistedScientist = scientistDao.save(newScientist);
		
		if(persistedScientist == null) {
			throw new ResourcePersistenceException("The scientist could not be persisted");
		}
		
		return true;
	}
	
	// TODO: refactor to responses
	public List<Scientist> getAllScientists(){
		return scientistDao.findAll();
	}
	
	//TODO: Impelement authentication
	@Transactional(readOnly = true)
	public Scientist authenticateScientist(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		Scientist authenticatedScientist = scientistDao.findScientistByUsernameAndPassword(username, password);
		
		if(authenticatedScientist == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		return authenticatedScientist;
	}

	@Transactional
	public boolean isEmailAvailable(String email) {
		return !scientistDao.findScientistByEmail(email).isPresent();
	}
	
	@Transactional
	public boolean isUsernameAvailable(String username) {
		return !scientistDao.findScientistByUsername(username).isPresent();
	}
	
	//Automatic Dirty Checking
	@Transactional
	public void updateScientist(UpdateScienitstRequest updateScientistRequest) {
		try {
			
			Scientist original = scientistDao.findById(updateScientistRequest.getId()).orElseThrow(ResourceNotFoundException::new);

            if (original == null) {
                throw new ResourceNotFoundException();
            }

            Predicate<String> notNullOrEmpty = str -> str != null && !str.equals("");

            if (notNullOrEmpty.test(updateScientistRequest.getFirstName())) {
                original.setFirstName(updateScientistRequest.getFirstName());
            } else if (notNullOrEmpty.test(updateScientistRequest.getLastName())) {
                original.setLastName(updateScientistRequest.getLastName());
            } else if (notNullOrEmpty.test(updateScientistRequest.getEmail())) {
                if (scientistDao.findScientistByEmail(updateScientistRequest.getEmail()) != null) {
                    throw new ResourcePersistenceException("The provided email is already by another user.");
                }
                original.setEmail(updateScientistRequest.getEmail());
            } else if (notNullOrEmpty.test(updateScientistRequest.getPassword())) {
                original.setPassword(updateScientistRequest.getPassword());
            }

			
		} catch (ResourcePersistenceException e) {
			throw e;
		} catch (Exception e) {
			throw new ResourcePersistenceException("Could not update user due to nest exception", e);
		}
	}

	
	
}
