package com.revature.banking_app.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.services.UserService;
import com.revature.banking_app.models.User;

public class DashboardMenu extends Menu {

	private final UserService userService;
	

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		
		User userSession = userService.getUserSession();

		if(userSession == null) {
			System.out.println("You are not logged-in! Rerouting to Login screen.");   
			router.transfer("/login");
			return;
		}
		
		while(userService.isSessionActive()) {
			System.out.println("\nWelcome " + userSession.getUsername());
			String menu =  "1) Create an account\n" +
						   "2) View your accounts\n" +
						   "3) Logout\n" +
						   "> ";
			System.out.print(menu);
			
			String userSelection = consoleReader.readLine();
		
			switch (userSelection) {
			case "1":
				router.transfer("/create-account");
				break;
			case "2":
				router.transfer("/view-accounts");
				break;
			case "3":
				userService.logout();
				break;
			default:
				System.out.println("Invalid Selection");
				
				
			}
		
		
		}
	}

}

