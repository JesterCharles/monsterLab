package com.revature.banking_app.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.banking_app.daos.UserDAO;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.exceptions.ResourcePersistenceException;
import com.revature.banking_app.models.User;


public class UserServiceTestSuite {
	
	UserService mockUserService;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		mockUserService = new UserService(mockUserDAO);
	}
	
	@Test
	public void test_isUserValid_returnsTrue_givenValidUser() {
		
		// Arrange
		User validUser = new User("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = mockUserService.isUserValid(validUser);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isUserValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		User invalidUser1 = new User("","valid","valid","valid","valid");
		User invalidUser2 = new User(null,"valid","valid","valid","valid");
		User invalidUser3 = new User("         ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = mockUserService.isUserValid(invalidUser1);
		boolean actualResult2 = mockUserService.isUserValid(invalidUser2);
		boolean actualResult3 = mockUserService.isUserValid(invalidUser3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	@Test
	public void test_registerUser_returnsTrue_givenValidUser() {
		// Arrange
		User validUser = new User("valid","valid","valid","valid","valid");
		when(mockUserDAO.findByUsername(validUser.getUsername())).thenReturn(null);
		when(mockUserDAO.findByEmail(validUser.getEmail())).thenReturn(null);
		when(mockUserDAO.create(validUser)).thenReturn(validUser);
		
		// Act
		User actualResult = mockUserService.registerNewUser(validUser);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockUserDAO, times(1)).create(validUser);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerUser_throwsInvalidRequestException_givenInvalidUser() {
		mockUserService.registerNewUser(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerUser_throwsResourcePersistenceException_givenUserWithTakenUsername() {
		
		// Arrange
		User usernameTakenUser = new User("valid","valid","valid","valid","valid");
		when(mockUserDAO.findByUsername(usernameTakenUser.getUsername())).thenReturn(usernameTakenUser);
		when(mockUserDAO.findByEmail(usernameTakenUser.getEmail())).thenReturn(null);
		when(mockUserDAO.create(usernameTakenUser)).thenReturn(usernameTakenUser);
		
		// Act
		try {
			mockUserService.registerNewUser(usernameTakenUser);
		} finally {
			// Assert
			verify(mockUserDAO, times(0)).create(usernameTakenUser);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerUser_throwsResourcePersistenceException_givenUserWithTakenEmail() {
			
			// Arrange
			User emailTakenUser = new User("valid","valid","valid","valid","valid");
			when(mockUserDAO.findByUsername(emailTakenUser.getUsername())).thenReturn(null);
			when(mockUserDAO.findByEmail(emailTakenUser.getEmail())).thenReturn(emailTakenUser);
			when(mockUserDAO.create(emailTakenUser)).thenReturn(emailTakenUser);
			
			// Act
			try {
				mockUserService.registerNewUser(emailTakenUser);
			} finally {
				// Assert
				verify(mockUserDAO, times(0)).create(emailTakenUser);
			}
		
		
	}
}