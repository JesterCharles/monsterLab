package com.revature.monster_lab.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.models.Scientist;


public class ScientistServiceTestSuite {
	
	ScientistService sut;
	
	@Before
	public void testPrep() {
		sut = new ScientistService();
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
	
	//TODO: Figure out implementation
	@Test
	public void test_registerScientist_returnsTrue_givenValidScientist() {
		
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerScientist_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewScientist(null);
	}
}
