package com.revature.monster_lab.menus.dashboardMenus;

import java.io.BufferedReader;

import com.revature.monster_lab.menus.Menu;
import com.revature.monster_lab.models.Scientist;
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

		Scientist sessionScientist = scientistService.getSessionScientist();

		if (sessionScientist == null) {
			System.out.println("You are not currently logged in! Rerouting to the login screen.....");
			router.transfer("/login");
			return;
		}

		while (scientistService.isSessionActive()) {
			System.out.println("Welcome " + sessionScientist.getUsername());
			String menu = "1) View/edit my profile information\n" + 
					"2) Edit/create monsters\n" +
					"3) View my monsters\n" + 
					"4) Logout\n" + 
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
				router.transfer("/create-monster");
				break;
			case "3":
				System.out.println("View My Monsters selected:");
				router.transfer("/my-monsters");
				break;
			case "4":
				scientistService.logout();
				break;
			default:
				System.out.println("The user made an invalid selection");
			}
		}
	}

}
