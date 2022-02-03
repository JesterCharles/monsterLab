package com.revature.monster_lab.menus;

import java.io.BufferedReader;

import com.revature.monster_lab.util.MenuRouter;

public class MonsterMenu extends Menu{
	
	public MonsterMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Monster", "/monster", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
