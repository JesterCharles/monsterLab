package com.revature.monster_lab.menus;

import java.io.BufferedReader;

import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.util.MenuRouter;

public class LoginMenu extends Menu {

	private final ScientistService scientistService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, ScientistService scientistSerivce) {
		super("Login", "/login", consoleReader, router);
		this.scientistService = scientistSerivce;
	}

	@Override
	public void render() throws Exception {
		 System.out.println("Please enter your credentials for you account.");
	     System.out.print("Username: ");
	      String username = consoleReader.readLine();
	      System.out.print("Password: ");
	        String password = consoleReader.readLine();
	        
	        // Implement an authentication and successful login:
	     
	        scientistService.autenticateScientist(username, password);
	        
	}

}
