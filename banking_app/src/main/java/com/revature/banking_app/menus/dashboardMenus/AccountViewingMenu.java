package com.revature.banking_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.models.Account;
import com.revature.banking_app.models.User;
import com.revature.banking_app.services.AccountService;
import com.revature.banking_app.services.UserService;
import com.revature.banking_app.util.collections.List;

public class AccountViewingMenu extends Menu {
	
	private final UserService userService;
	private final AccountService accountService;
	
	public AccountViewingMenu(BufferedReader consoleReader, MenuRouter router, UserService userService, AccountService accountService) {
		super("AccountViewing", "/view-accounts", consoleReader, router);
		this.accountService = accountService;
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		
		User userSession = userService.getUserSession();
		
		List<Account> userAccounts = accountService.findMyAccounts(userSession.getUserId());
		
		System.out.println("\n"+userSession.getUsername()+"\'s\'"+" accounts:");
		
		for(int i = 0; i < userAccounts.size(); i++) {
			Account account = userAccounts.get(i);
			String balanceStr = Integer.toString(account.getDollars())+"."+Integer.toString(account.getCents());
			//String acctStr = Integer.toString(i+1)+") Name:"+account.getAccountName()+" Balance:"+balanceStr;
			
			//System.out.println(acctStr);
			
			System.out.printf("%d) Name:%-18s Balance: %s%n", i+1, account.getAccountName(), balanceStr);
		}
		
		System.out.print("\nEnter the number of the account you want to view/edit\n or enter \'q\' to return to your dashboard.\n> ");
		
		String userSelection = consoleReader.readLine();
	
		if(userSelection.equals("q")) {
			router.transfer("/dashboard");
		}
		else if(Integer.parseInt(userSelection) <= userAccounts.size()+1){
			Account selectedAccount = userAccounts.get(Integer.parseInt(userSelection)-1);
			userSession.setAccountToModify(selectedAccount);			
			router.transfer("/edit-account");
		}
		else {
			System.out.println("I didn't understand your input");
			router.transfer("/view-accounts");
		}
		
	}
}