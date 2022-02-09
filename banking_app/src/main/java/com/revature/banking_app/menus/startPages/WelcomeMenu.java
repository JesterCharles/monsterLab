package com.revature.banking_app.menus.startPages;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import static com.revature.banking_app.util.AppState.shutdown;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		System.out.print("\nWelcome to the Bank App!\n" + "1) Login\n" + "2) Register\n" + "3) Exit\n" + "> ");
		
		String userSelection = consoleReader.readLine();
		
		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("What on earth are you trying to tell me to do?!?!");
			break;
		}
		
	}

}
