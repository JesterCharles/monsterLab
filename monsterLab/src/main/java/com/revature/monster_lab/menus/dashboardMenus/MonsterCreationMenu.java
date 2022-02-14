package main.java.com.revature.monster_lab.menus.dashboardMenus;

import java.io.BufferedReader;

import main.java.com.revature.monster_lab.menus.Menu;
import main.java.com.revature.monster_lab.models.Monster;
import main.java.com.revature.monster_lab.services.MonsterService;
import main.java.com.revature.monster_lab.util.MenuRouter;

public class MonsterCreationMenu extends Menu {

	private final MonsterService monsterService;
	
	public MonsterCreationMenu(BufferedReader consoleReader, MenuRouter router, MonsterService monsterService) {
		super("MonsterCreation", "/create-monster", consoleReader, router);
		this.monsterService = monsterService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		System.out.println("Monster Creator\n" + "Fill out the attributes below");
		
		System.out.println("1 - Name");
		String monsterName = consoleReader.readLine();
		System.out.println("2 - Type");
		String monsterType = consoleReader.readLine();
		System.out.println("3 - Strength");
		String strength = consoleReader.readLine();
		System.out.println("4 - Dexterity");
		String dexterity = consoleReader.readLine();
		System.out.println("5 - Intelligence");
		String intelligence = consoleReader.readLine();
		
		Monster newMonster = new Monster(monsterName, monsterType, strength, dexterity, intelligence);
		
		monsterService.createMonster(newMonster);
	}

}
