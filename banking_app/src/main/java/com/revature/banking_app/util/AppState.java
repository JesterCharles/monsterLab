package com.revature.banking_app.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.banking_app.daos.UserDAO;
import com.revature.banking_app.daos.AccountDAO;

import com.revature.banking_app.menus.dashboardMenus.DashboardMenu;
import com.revature.banking_app.menus.dashboardMenus.AccountCreationMenu;
import com.revature.banking_app.menus.dashboardMenus.AccountViewingMenu;
import com.revature.banking_app.menus.dashboardMenus.AccountEditingMenu;

import com.revature.banking_app.menus.startPages.LoginMenu;
import com.revature.banking_app.menus.startPages.RegisterMenu;
import com.revature.banking_app.menus.startPages.WelcomeMenu;


import com.revature.banking_app.services.UserService;
import com.revature.banking_app.services.AccountService;

import com.revature.banking_app.util.logging.Logger;

public class AppState {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		
		logger = Logger.getLogger(true);
		logger.log("Application is initiliazing.....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		UserDAO userDAO = new UserDAO();
		AccountDAO accountDAO = new AccountDAO();
		UserService userService = new UserService(userDAO);
		AccountService accountService = new AccountService(accountDAO, userService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, userService));
		router.addMenu(new LoginMenu(consoleReader, router, userService));
		router.addMenu(new DashboardMenu(consoleReader, router, userService));
		router.addMenu(new AccountCreationMenu(consoleReader, router, userService, accountService));
		router.addMenu(new AccountViewingMenu(consoleReader, router, userService, accountService));
		router.addMenu(new AccountEditingMenu(consoleReader, router, userService, accountService));
		
		logger.log("Application initiliazed.");
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}