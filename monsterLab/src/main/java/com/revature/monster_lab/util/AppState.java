package com.revature.monster_lab.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.monster_lab.daos.MonsterDAO;
import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.menus.dashboardMenus.DashboardMenu;
import com.revature.monster_lab.menus.dashboardMenus.MonsterCreationMenu;
import com.revature.monster_lab.menus.dashboardMenus.MonsterMenu;
import com.revature.monster_lab.menus.startPages.LoginMenu;
import com.revature.monster_lab.menus.startPages.RegisterMenu;
import com.revature.monster_lab.menus.startPages.WelcomeMenu;
import com.revature.monster_lab.services.MonsterService;
import com.revature.monster_lab.services.ScientistService;

public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		ScientistDAO scientistDAO = new ScientistDAO();
		MonsterDAO monsterDAO = new MonsterDAO();
		ScientistService scientistService = new ScientistService(scientistDAO);
		MonsterService monsterService = new MonsterService(monsterDAO, scientistService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, scientistService));
		router.addMenu(new LoginMenu(consoleReader, router, scientistService));
		router.addMenu(new DashboardMenu(consoleReader, router, scientistService));
		router.addMenu(new MonsterMenu(consoleReader, router));
		router.addMenu(new MonsterCreationMenu(consoleReader, router, monsterService));
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
