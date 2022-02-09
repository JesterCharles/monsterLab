package com.revature.banking_app.menus.startPages;

import java.io.BufferedReader;
import com.revature.banking_app.menus.Menu;
import com.revature.banking_app.exceptions.InvalidRequestException;
import com.revature.banking_app.util.MenuRouter;
import com.revature.banking_app.models.User;
import com.revature.banking_app.services.UserService;

public class RegisterMenu extends Menu {

	private final UserService userService;
	
	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("Register", "/register", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The User selected Register");

		// Things to obtain from user: first name, last name, email,username, password

		System.out.println("Please provided us with some basic information");
		System.out.print("First Name: ");
		String firstName = consoleReader.readLine();

		System.out.print("Last Name: ");
		String lastName = consoleReader.readLine();

		System.out.print("Email: ");
		String email = consoleReader.readLine();

		System.out.print("Username: ");
		String username = consoleReader.readLine();

		System.out.print("Password: ");
		String password = consoleReader.readLine();

		User user = new User(firstName, lastName, email, username, password);

		try {
			userService.registerNewUser(user);
			userService.authenticateUser(username, password);
			router.transfer("/dashboard");
		}
		catch (InvalidRequestException e) {
			System.out.println("Invalid data Provided. Please Try Again\n\n\n");
			router.transfer("/welcome");
		}

	}

}

