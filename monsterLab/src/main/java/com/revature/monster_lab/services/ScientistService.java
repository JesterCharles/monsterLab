package com.revature.monster_lab.services;

import java.io.File;
import java.io.FileWriter;

import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.List;

public class ScientistService {

	private ScientistDAO scientistDao = new ScientistDAO();
	
	public boolean registerNewScientist(Scientist newScientist) {
		if(!isScientistValid(newScientist)) {
			throw new InvalidRequestException("Invalid user data provider");
		}

		// TODO: Write logic that verifies the new users information isn't duplicated int he system
		scientistDao.create(newScientist);
		

		return true;
	}
	
	public List<Scientist> getAllScientists(){
		return scientistDao.findAll();		
	}
	
	//TODO: Impelement authentication
	public Scientist autenticateScientist(String username, String password) {
		scientistDao.findByUsernameAndPassword(username, password);
		return null;
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
