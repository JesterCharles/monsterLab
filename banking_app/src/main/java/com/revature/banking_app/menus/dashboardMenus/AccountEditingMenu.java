package com.revature.banking_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.models.Account;
import com.revature.banking_app.models.User;
import com.revature.banking_app.services.AccountService;
import com.revature.banking_app.services.UserService;

public class AccountEditingMenu extends Menu {
	
	private final UserService userService;
	private final AccountService accountService;
	
	public AccountEditingMenu(BufferedReader consoleReader, MenuRouter router, UserService userService, AccountService accountService) {
		super("AccountViewing", "/edit-account", consoleReader, router);
		this.accountService = accountService;
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		
		User userSession = userService.getUserSession();
		
		Account account = (Account) userSession.getAccountToModify();
		account.setCreator(userSession);
		
		String accountInfoStr = "\nName:"+account.getAccountName()+" Balance:"+account.getDollars()+"."+account.getCents()+
								"\n1) Deposit"+
								"\n2) Withdraw"+
								"\n3) Return to Previous Menu\n>";
		System.out.print(accountInfoStr);
		
		String userSelection = consoleReader.readLine();
		
		switch (userSelection) {
		case "1": // deposit
			System.out.print("Enter amount to DEPOSIT (Example >100.25\nor press \'q\' to return to the previous menu");
			String depositAmount = consoleReader.readLine();
			if(userSelection.equals("q")) { router.transfer("/edit-account"); }
			
			String depositArray[] = depositAmount.split("\\.");
			
			if(Integer.parseInt(depositArray[0]) < 0 || Integer.parseInt(depositArray[1]) < 0) {
				System.out.println("\nInvalid amount entered.");
				router.transfer("/edit-account");
			}
			
			int totalCents=0, dollarsFromCents=0, cents = 0;
			
			
			
			if(depositArray.length > 1) {
				totalCents = account.getCents() + Integer.parseInt(depositArray[1]); 								
				cents = totalCents % 100;
				dollarsFromCents = totalCents - (cents);
			}
			else {
				cents = account.getCents();
			}

			account.setCents(cents);
			account.setDollars(account.getDollars() + Integer.parseInt(depositArray[0]) + dollarsFromCents);
			
			accountService.updateAccount(account);
			router.transfer("/edit-acccount");
			break;
		case "2": // withdraw
			System.out.print("Enter amount to Withdraw (Example >100.25\nor press \'q\' to return to the previous menu");
			String withdrawAmount = consoleReader.readLine();
			if(userSelection.equals("q")) { router.transfer("/edit-account"); }
			
			String withdrawArray[] = withdrawAmount.split("\\.");
		
			
			
			int dollarsRemaining = account.getDollars() - Integer.parseInt(withdrawArray[0]);
			int centsRemaining = account.getCents();
			if(withdrawArray.length > 1) {
				centsRemaining -= Integer.parseInt(withdrawArray[1]);				
			}
			
			if(dollarsRemaining < 0) {
				System.out.println("Error: Not enough funds for withdrawal.");
				router.transfer("/edit-account"); 
			} else if(dollarsRemaining == 0 && centsRemaining < 0) {
				System.out.println("Error: Not enough funds for withdrawal.");
				router.transfer("/edit-account"); 
			} else if(centsRemaining < 0) {
				dollarsRemaining -= 1;
				centsRemaining += 100;
			
				if(dollarsRemaining < 0) {
					System.out.println("Error: Not enough funds for withdrawal.");
					router.transfer("/edit-account"); 
				}
			}
			
			account.setDollars(dollarsRemaining);
			account.setCents(centsRemaining);
			
			accountService.updateAccount(account);
			router.transfer("/edit-acccount");
			break;
		case "3":
			router.transfer("/view-acccount");
			break;
		default:
			System.out.println("Invalid Selection");
		}
	}
}
