package com.revature.monster_lab.web.servlets;

import com.revature.monster_lab.services.MonsterService;

public class MonsterServlet{
	private final MonsterService monsterService;
	
	public MonsterServlet(MonsterService monsterService) {
		this.monsterService = monsterService;
	}

}
