package com.revature.monster_lab.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.web.dto.ScientistRequest;


public class ScientistServiceTestSuite {
	
	ScientistService sut;
	ScientistDAO mockScientistDAO;
	
	@Before
	public void testPrep() {
		mockScientistDAO = mock(ScientistDAO.class);
		sut = new ScientistService(mockScientistDAO);
	}
	
	@Test
	public void test_isScientistValid_returnsTrue_givenValidUser() {
		
		// Arrange
		ScientistRequest validScientist = new ScientistRequest("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = sut.isScientistValid(validScientist);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isScientistValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		ScientistRequest invalidScientist1 = new ScientistRequest("","valid","valid","valid","valid");
		ScientistRequest invalidScientist2 = new ScientistRequest(null,"valid","valid","valid","valid");
		ScientistRequest invalidScientist3 = new ScientistRequest("         ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = sut.isScientistValid(invalidScientist1);
		boolean actualResult2 = sut.isScientistValid(invalidScientist2);
		boolean actualResult3 = sut.isScientistValid(invalidScientist3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	//TODO: Figure out implementation. CHARLES YOU DINGLEBERRY MOCK IT!!!!!!!
	@Test
	public void test_registerScientist_returnsTrue_givenValidScientist() {
		// Arrange
		ScientistRequest validScientist = new ScientistRequest("valid","valid","valid","valid","valid");
		Scientist scientist = new Scientist(validScientist.getFirstName(),validScientist.getLastName(), validScientist.getEmail(), validScientist.getUsername(), validScientist.getPassword());
		when(mockScientistDAO.findByUsername(validScientist.getUsername())).thenReturn(null);
		when(mockScientistDAO.findByEmail(validScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(scientist)).thenReturn(scientist);
		
		// Act
		boolean actualResult = sut.registerNewScientist(validScientist);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockScientistDAO, times(1)).create(scientist);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerScientist_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewScientist(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenUsername() {
		
		// Arrange
		ScientistRequest usernameTakenScientist = new ScientistRequest("valid","valid","valid","valid","valid");
		Scientist scientist = new Scientist(usernameTakenScientist.getFirstName(),usernameTakenScientist.getLastName(), usernameTakenScientist.getEmail(), usernameTakenScientist.getUsername(), usernameTakenScientist.getPassword());
		when(mockScientistDAO.findByUsername(usernameTakenScientist.getUsername())).thenReturn(scientist);
		when(mockScientistDAO.findByEmail(usernameTakenScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(scientist)).thenReturn(scientist);
		
		// Act
		try {
			sut.registerNewScientist(usernameTakenScientist);
		} finally {
			// Assert
			verify(mockScientistDAO, times(0)).create(scientist);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenEmail() {
			
			// Arrange
			ScientistRequest emailTakenScientist = new ScientistRequest("valid","valid","valid","valid","valid");
			Scientist scientist = new Scientist(emailTakenScientist.getFirstName(),emailTakenScientist.getLastName(), emailTakenScientist.getEmail(), emailTakenScientist.getUsername(), emailTakenScientist.getPassword());
			when(mockScientistDAO.findByUsername(emailTakenScientist.getUsername())).thenReturn(null);
			when(mockScientistDAO.findByEmail(emailTakenScientist.getEmail())).thenReturn(scientist);
			when(mockScientistDAO.create(scientist)).thenReturn(scientist);
			
			// Act
			try {
				sut.registerNewScientist(emailTakenScientist);
			} finally {
				// Assert
				verify(mockScientistDAO, times(0)).create(scientist);
			}
		
		
	}
}
