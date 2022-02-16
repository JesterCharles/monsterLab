package main.java.com.revature.monster_lab.menus.startPages;

import java.io.BufferedReader;

import main.java.com.revature.monster_lab.menus.Menu;
import main.java.com.revature.monster_lab.util.MenuRouter;
import static main.java.com.revature.monster_lab.util.AppState.shutdown;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		System.out.print(
				"Welcome to the Monster Laboratory!\n" + "1) Login\n" + "2) Register\n" + "3) Exits\n" + "> ");
		
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
