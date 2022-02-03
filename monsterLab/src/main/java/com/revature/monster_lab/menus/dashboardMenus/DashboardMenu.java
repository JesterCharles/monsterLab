package com.revature.monster_lab.menus;

import java.io.BufferedReader;

import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.util.MenuRouter;

public class DashboardMenu extends Menu {

	private final ScientistService scientistService;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, ScientistService scientistService) {
		super("Dashboard", "/dashboard", consoleReader, router);
		this.scientistService = scientistService;
	}

	@Override
	public void render() throws Exception {

		// TODO: Work on implementing sessions & dashboard functionality
		
		String menu = "1) View/edit my profile information\n" + 
				"2) View/edit/create monsters\n" + 
				"3) Logout\n" +
				"> ";

		System.out.print(menu);

		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			System.out.println("View/edit profile selected");
			router.transfer("/user-profile-edit");
			break;
		case "2":
			System.out.println("View/edit/create monsters selected");
			break;
		case "3":
			// TODO: Implement logout of user account
			break;
		default:
			System.out.println("The user made an invalid selection");
		}
	}

}
