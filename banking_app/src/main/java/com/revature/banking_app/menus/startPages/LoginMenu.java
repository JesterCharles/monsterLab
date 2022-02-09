package com.revature.banking_app.menus.startPages;

import java.io.BufferedReader;

import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.services.UserService;
import com.revature.banking_app.exceptions.AuthenticationException;

public class LoginMenu extends Menu {

	private final UserService userService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Login", "/login", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		System.out.print("Please enter your Username and Password.\n");
		System.out.print("Username: ");
		String username = consoleReader.readLine();
		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		try {
			userService.authenticateUser(username, password);
			router.transfer("/dashboard");
		} catch (AuthenticationException e){
			System.out.println("Incorrect credentials provided! No matching user account found.");
			router.transfer("/welcome");
		}
	}
}
