package main.java.com.revature.monster_lab.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.java.com.revature.monster_lab.daos.MonsterDAO;
import main.java.com.revature.monster_lab.daos.ScientistDAO;
import main.java.com.revature.monster_lab.menus.dashboardMenus.DashboardMenu;
import main.java.com.revature.monster_lab.menus.dashboardMenus.MonsterCreationMenu;
import main.java.com.revature.monster_lab.menus.dashboardMenus.MonsterMenu;
import main.java.com.revature.monster_lab.menus.startPages.LoginMenu;
import main.java.com.revature.monster_lab.menus.startPages.RegisterMenu;
import main.java.com.revature.monster_lab.menus.startPages.WelcomeMenu;
import main.java.com.revature.monster_lab.services.MonsterService;
import main.java.com.revature.monster_lab.services.ScientistService;
import main.java.com.revature.monster_lab.util.logging.Logger;

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
		
		logger.log("Application initiliazed!!! We do did it!~WOOO~");
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
