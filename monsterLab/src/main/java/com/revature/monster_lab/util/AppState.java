package com.revature.monster_lab.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.monster_lab.daos.MonsterDAO;
import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.services.MonsterService;
import com.revature.monster_lab.services.ScientistService;

public class AppState {

	private final Logger logger = LogManager.getLogger();
	private static boolean isRunning;

	public AppState() {
		
		logger.info("Application is initiliazing.....");
		
		isRunning = true;
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		ScientistDAO scientistDAO = new ScientistDAO();
		MonsterDAO monsterDAO = new MonsterDAO();
		ScientistService scientistService = new ScientistService(scientistDAO);
		MonsterService monsterService = new MonsterService(monsterDAO, scientistService);
		
		
		logger.info("Application initiliazed!!! We do did it!~WOOO~");
	}
	
	
}
