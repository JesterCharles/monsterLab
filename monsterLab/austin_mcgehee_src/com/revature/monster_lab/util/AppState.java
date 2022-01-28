package com.revature.monster_lab.util;

import com.revature.monster_lab.menus.RegisterMenu;
import com.revature.monster_lab.menus.WelcomeMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
	
	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader,router));
		
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
