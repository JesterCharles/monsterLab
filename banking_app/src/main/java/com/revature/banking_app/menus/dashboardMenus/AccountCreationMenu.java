package com.revature.banking_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.models.Account;
import com.revature.banking_app.models.User;
import com.revature.banking_app.services.AccountService;
import com.revature.banking_app.services.UserService;

public class AccountCreationMenu extends Menu {
	
	private final UserService userService;
	private final AccountService accountService;
	
	public AccountCreationMenu(BufferedReader consoleReader, MenuRouter router, UserService userService, AccountService accountService) {
		super("AccountCreation", "/create-account", consoleReader, router);
		this.accountService = accountService;
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		System.out.print("Account Creator\n");
		
		System.out.print("1 - Please give your account a NickName:\n> ");
		String accountName = consoleReader.readLine();
		System.out.print("2 - Enter the initial Deposit (Example >100.25\n");
		String initialDeposit = consoleReader.readLine();
		
		User userSession = userService.getUserSession();
		
		Account newAccount = new Account(userSession.getUserId(), accountName, initialDeposit, userSession);
		
		accountService.createAccount(newAccount);
	}
}