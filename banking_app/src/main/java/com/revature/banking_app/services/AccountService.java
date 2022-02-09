package com.revature.banking_app.services;

import com.revature.banking_app.daos.AccountDAO;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.exceptions.ResourcePersistenceException;
import com.revature.banking_app.models.Account;
import com.revature.banking_app.util.collections.List;

public class AccountService {
	
	private final AccountDAO accountDAO;
	private final UserService userService;
	
	public AccountService(AccountDAO accountDAO, UserService userService) {
		this.accountDAO = accountDAO;
		this.userService = userService;
	}
	
	// TODO: Account Creation implementation
	public Account createAccount(Account newAccount) {
		if(!isAccountValid(newAccount)) {
			throw new InvalidRequestException("The account was provided invalid information");
		}
		
		newAccount.setCreator(newAccount.getCreator());
		Account createdAccount = accountDAO.create(newAccount);
		
		if(createdAccount == null) {
			throw new ResourcePersistenceException("The account could not be persisted");
		}
		
		return newAccount;
	}
	
	boolean isAccountValid(Account newAccount) {
		if(newAccount == null) return false;
		if(newAccount.getAccountName() == null || newAccount.getAccountName().trim().equals("")) return false;
		return newAccount.getDollars() >= 0 && newAccount.getCents() >= 0;
	}
	
	public List<Account> findMyAccounts(String id){
		return this.accountDAO.findAccountByCreatorId(id);
	}
	
	public boolean updateAccount(Account account) {
		return accountDAO.update(account);
	}
	
	/*public List<Account> findAllAccounts(){
		return null;
	}*/

}