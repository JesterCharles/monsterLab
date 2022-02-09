package com.revature.banking_app.services;

import com.revature.banking_app.daos.UserDAO;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.exceptions.AuthenticationException;
import com.revature.banking_app.exceptions.ResourcePersistenceException;
import com.revature.banking_app.models.User;

public class UserService {

	private final UserDAO userDAO;
	private User userSession;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.userSession = null;
	}

	public User getUserSession() {
		return this.userSession;
	}
	
	public User registerNewUser(User newUser) {
		if(!isUserValid(newUser)) {
			throw new InvalidRequestException("Invalid user data provided");
		}
		
		boolean usernameAvailable = userDAO.findByUsername(newUser.getUsername()) == null;
		boolean emailAvailable = userDAO.findByEmail(newUser.getEmail()) == null;

		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username is already taken.");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email is already taken.");
			} else {
				throw new ResourcePersistenceException("The provided username and email are already taken.");
			}
		}
		
		User persistedUser = userDAO.create(newUser);
		
		if(persistedUser == null) {
			throw new ResourcePersistenceException("The user could not be persisted");

		}
		return persistedUser;
	}
	
	public void authenticateUser(String username, String password) {
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Username or password is invalid. Please try logging in again");
		}
	
		User authenticatedUser = userDAO.findByUsernameAndPassword(username, password);
	
		if(authenticatedUser == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found.");
		}
		userSession = authenticatedUser; 
	}
	
	
	public boolean isUserValid(User newUser) {
		if(newUser == null) return false;
		if(newUser.getFirstName() == null || newUser.getFirstName().trim().equals("")) return false;
		if(newUser.getLastName() == null || newUser.getLastName().trim().equals("")) return false;
		if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) return false;
		if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) return false;
		return newUser.getPassword() != null || !newUser.getPassword().trim().equals("");


	}
	
	public void logout() {
		userSession = null;
	}

	public boolean isSessionActive() {
		return userSession != null;
	}
}
