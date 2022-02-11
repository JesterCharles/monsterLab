package com.revature.monster_lab.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.monster_lab.daos.MonsterDAO;
import com.revature.monster_lab.daos.ScientistDAO;
import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.services.MonsterService;
import com.revature.monster_lab.services.ScientistService;


// @WebServlet("/monsters") ONLY TAKES DEFAULT CONSTRUCTORS. This is commented out because we created a new Constructor.
public class MonsterServlet extends HttpServlet{
	private final MonsterService monsterService;
	private final ObjectMapper mapper;
	
	public MonsterServlet(MonsterService monsterService, ObjectMapper mapper) {
		this.monsterService = monsterService;
		this.mapper = mapper;
	}
	
//	@Override
//	public void init() throws ServletException {
//		System.out.println("Hey look it's me the monster servlet");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Monster> monsters = monsterService.findAllMonsters();
		
		String payload = mapper.writeValueAsString(monsters);
		
		resp.getWriter().write(payload);
	}
	
}
