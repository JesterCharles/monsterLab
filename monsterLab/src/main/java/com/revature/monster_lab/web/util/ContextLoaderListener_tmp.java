package com.revature.monster_lab.web.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.monster_lab.daos.MonsterDAO;
import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.services.MonsterService;
import com.revature.monster_lab.services.ScientistService;
import com.revature.monster_lab.web.servlets.AuthServlet;
import com.revature.monster_lab.web.servlets.MonsterServlet;

@WebListener
public class ContextLoaderListener_tmp implements ServletContextListener{
	
	private final Logger logger = LogManager.getLogger();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		logger.info("Application is initiliazing.....");
//		ObjectMapper mapper = new ObjectMapper();
//		
//		ScientistDAO scientistDAO = new ScientistDAO();
//		MonsterDAO monsterDAO = new MonsterDAO();
//		ScientistService scientistService = new ScientistService(scientistDAO);
//		MonsterService monsterService = new MonsterService(monsterDAO, scientistService);
//		
//		MonsterServlet monsterServlet = new MonsterServlet(monsterService, mapper);
//		AuthServlet authServlet = new AuthServlet(scientistService, mapper);
//		
//		ServletContext context = sce.getServletContext();
//		context.addServlet("MonsterServlet", monsterServlet).addMapping("/monsters/*");
//		context.addServlet("AuthServlet", authServlet).addMapping("/auth");
//		
//		logger.info("Application initiliazed!!! We do did it!~WOOO~");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
	
}
