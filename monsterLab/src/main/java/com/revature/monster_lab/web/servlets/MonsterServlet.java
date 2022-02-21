package com.revature.monster_lab.web.servlets;

import org.springframework.web.bind.annotation.RestController;

import com.revature.monster_lab.services.MonsterService;

@RestController
public class MonsterServlet{
	private final MonsterService monsterService;
	
	public MonsterServlet(MonsterService monsterService) {
		this.monsterService = monsterService;
	}

}
