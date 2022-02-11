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
		Scientist validScientist = new Scientist("valid","valid","valid","valid","valid");
		
		// Act
		boolean actualResult = sut.isScientistValid(validScientist);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isScientistValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		Scientist invalidScientist1 = new Scientist("","valid","valid","valid","valid");
		Scientist invalidScientist2 = new Scientist(null,"valid","valid","valid","valid");
		Scientist invalidScientist3 = new Scientist("         ","valid","valid","valid","valid");
		
		
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
		Scientist validScientist = new Scientist("valid","valid","valid","valid","valid");
		when(mockScientistDAO.findByUsername(validScientist.getUsername())).thenReturn(null);
		when(mockScientistDAO.findByEmail(validScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(validScientist)).thenReturn(validScientist);
		
		// Act
		Scientist actualResult = sut.registerNewScientist(validScientist);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockScientistDAO, times(1)).create(validScientist);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerScientist_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewScientist(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenUsername() {
		
		// Arrange
		Scientist usernameTakenScientist = new Scientist("valid","valid","valid","valid","valid");
		when(mockScientistDAO.findByUsername(usernameTakenScientist.getUsername())).thenReturn(usernameTakenScientist);
		when(mockScientistDAO.findByEmail(usernameTakenScientist.getEmail())).thenReturn(null);
		when(mockScientistDAO.create(usernameTakenScientist)).thenReturn(usernameTakenScientist);
		
		// Act
		try {
			sut.registerNewScientist(usernameTakenScientist);
		} finally {
			// Assert
			verify(mockScientistDAO, times(0)).create(usernameTakenScientist);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerScientist_throwsResourcePersistenceException_givenScientistWithTakenEmail() {
			
			// Arrange
			Scientist emailTakenScientist = new Scientist("valid","valid","valid","valid","valid");
			when(mockScientistDAO.findByUsername(emailTakenScientist.getUsername())).thenReturn(null);
			when(mockScientistDAO.findByEmail(emailTakenScientist.getEmail())).thenReturn(emailTakenScientist);
			when(mockScientistDAO.create(emailTakenScientist)).thenReturn(emailTakenScientist);
			
			// Act
			try {
				sut.registerNewScientist(emailTakenScientist);
			} finally {
				// Assert
				verify(mockScientistDAO, times(0)).create(emailTakenScientist);
			}
		
		
	}
}
