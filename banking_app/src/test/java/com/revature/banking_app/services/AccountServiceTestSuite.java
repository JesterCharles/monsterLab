package com.revature.banking_app.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.banking_app.daos.AccountDAO;
import com.revature.banking_app.daos.UserDAO;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.exceptions.ResourcePersistenceException;
import com.revature.banking_app.models.Account;
import com.revature.banking_app.models.User;


public class AccountServiceTestSuite {
	
	AccountService mockAccountService;
	UserService mockUserService;
	AccountDAO mockAccountDAO;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockAccountDAO = mock(AccountDAO.class);
		mockUserDAO = mock(UserDAO.class);
		mockAccountService = new AccountService(mockAccountDAO, mockUserService);
		mockUserService = new UserService(mockUserDAO);
	}
	
	@Test
	public void test_isAccountValid_returnsTrue_givenValidAccount() {
		
		// Arrange
		Account validAccount1 = new Account("valid","valid", "11.11", mockUserService.getUserSession());
		Account validAccount2 = new Account("valid","valid", 1, 1, mockUserService.getUserSession());
		// Act
		boolean actualResult1 = mockAccountService.isAccountValid(validAccount1);
		boolean actualResult2 = mockAccountService.isAccountValid(validAccount2);
		// Assert
		Assert.assertTrue(actualResult1);
		Assert.assertTrue(actualResult2);
		
	}
	
	@Test
	public void test_isAccountValid_returnsTrue_givenInvalidAccount() {
		
		// Arrange
		Account validAccount1 = new Account("valid"," ", "12.13", mockUserService.getUserSession());
		Account validAccount2 = new Account("valid","valid", -5, 1, mockUserService.getUserSession());
		// Act
		boolean actualResult1 = mockAccountService.isAccountValid(validAccount1);
		boolean actualResult2 = mockAccountService.isAccountValid(validAccount2);
		// Assert
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		
	}
	
	@Test
	public void test_createAccount_returnsTrue_givenValidValues() {
		
		Account validAccount1 = new Account("valid","valid", "12.12", mockUserService.getUserSession());
		Account validAccount2 = new Account("valid","valid", 1, 1, mockUserService.getUserSession());
		
		when(mockAccountDAO.findAccountByCreatorId(validAccount1.getAccountId())).thenReturn(null);
		when(mockAccountDAO.create(validAccount1)).thenReturn(validAccount1);
		
		when(mockAccountDAO.findAccountByCreatorId(validAccount2.getAccountId())).thenReturn(null);
		when(mockAccountDAO.create(validAccount2)).thenReturn(validAccount2);
		
		// Act
		Account actualResult1 = mockAccountService.createAccount(validAccount1);
		Account actualResult2 = mockAccountService.createAccount(validAccount2);
		
		// Assert
		Assert.assertNotNull(actualResult1);
		Assert.assertNotNull(actualResult2);
		verify(mockAccountDAO, times(1)).create(validAccount1);
		verify(mockAccountDAO, times(1)).create(validAccount2);
	}
	
}