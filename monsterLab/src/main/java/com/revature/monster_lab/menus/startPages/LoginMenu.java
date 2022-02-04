package com.revature.monster_lab.menus.startPages;

import java.io.BufferedReader;

import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.menus.Menu;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.util.MenuRouter;
import com.revature.monster_lab.util.collections.List;

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
	        
	     // Test for a select all
//	     List<Scientist> test = scientistService.getAllScientists();
//	     System.out.println(test.get(0));
	     // Implement an authentication and successful login:
	     try {
	    	 scientistService.authenticateScientist(username, password);
	    	 router.transfer("/dashboard");
	        } catch (AuthenticationException e) {
	            System.out.println("Incorrect credentials provided! No matching user account found.");
	        }
	     
	        
	}

}
