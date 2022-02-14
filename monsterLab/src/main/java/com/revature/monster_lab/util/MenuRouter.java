package main.java.com.revature.monster_lab.util;

import main.java.com.revature.monster_lab.menus.Menu;
import main.java.com.revature.monster_lab.util.collections.LinkedList;

public class MenuRouter {
	private final LinkedList<Menu> menus;
	
	public MenuRouter() {
		menus = new LinkedList<>();
	}
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
	public void transfer(String route) throws Exception{
		for(int i = 0; i < menus.size(); i++) {
			Menu currentMenu = menus.get(i);
			if(currentMenu.getRoute().equals(route)) {
				currentMenu.render();
			}
		}
	}
	
}
