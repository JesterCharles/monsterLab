package com.revature.monster_lab.menus;

import java.io.BufferedReader;

public class WelcomeMenu extends Menu {

	public WelcomeMenu(String name, String route, BufferedReader consoleReader) {
		super(name, route, consoleReader);
	}

	@Override
	public void render() throws Exception {
		String userSelection = consoleReader.readLine();
		
		System.out.println(
				"Welcome to the Mosnter Laboratory!\n" + "1) Login\n" + "2) Register\n" + "3) Exits\n" + "> ");

		
		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			// System.exit(0); BAD PRACTICE
			break;
		default:
			System.out.println("What on earth are you trying to tell me to do?!?!");
			break;
		}
		
	}

}
