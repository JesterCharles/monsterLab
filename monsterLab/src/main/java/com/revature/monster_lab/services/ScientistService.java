package main.java.com.revature.monster_lab.services;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

<<<<<<< HEAD
import main.java.com.revature.monster_lab.daos.ScientistDAO;
import main.java.com.revature.monster_lab.exceptions.AuthenticationException;
import main.java.com.revature.monster_lab.exceptions.InvalidRequestException;
import main.java.com.revature.monster_lab.exceptions.ResourcePersistenceException;
import main.java.com.revature.monster_lab.models.Scientist;
import main.java.com.revature.monster_lab.util.collections.List;
=======
import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Scientist;
>>>>>>> e15cb32b79c5ab59dce2744207e725dafc1e8e16


// THIS IS PURELY BUSINESS LOGIC
// WAT IT MEME?
// Business validation steps. Is what's been entered appropriate or valid? It might call checks to the DAO
// but never touch the database directly
public class ScientistService {

	private final ScientistDAO scientistDao;
	
	// DI - Dependency Injection of the DAO
	public ScientistService(ScientistDAO scientistDAO) {
		this.scientistDao = scientistDAO;
	}
	
	public Scientist registerNewScientist(Scientist newScientist) {
		if(!isScientistValid(newScientist)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

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

	private boolean isScientistValid(Scientist newScientist) {
		if(newScientist == null) return false;
		if(newScientist.getFirstName() == null || newScientist.getFirstName().trim().equals("")) return false;
		if(newScientist.getLastName() == null || newScientist.getLastName().trim().equals("")) return false;
		if(newScientist.getEmail() == null || newScientist.getEmail().trim().equals("")) return false;
		if(newScientist.getUsername() == null || newScientist.getUsername().trim().equals("")) return false;
		return newScientist.getPassword() != null && !newScientist.getPassword().trim().equals("");


	}
	
}
