package main.java.com.revature.monster_lab.services;

import main.java.com.revature.monster_lab.daos.MonsterDAO;
import main.java.com.revature.monster_lab.exceptions.InvalidRequestException;
import main.java.com.revature.monster_lab.exceptions.ResourcePersistenceException;
import main.java.com.revature.monster_lab.models.Monster;
import main.java.com.revature.monster_lab.util.collections.List;

public class MonsterService {
	
	private final MonsterDAO monsterDAO;
	private final ScientistService scientistService;
	
	public MonsterService(MonsterDAO monsterDAO, ScientistService scientistService) {
		this.monsterDAO = monsterDAO;
		this.scientistService = scientistService;
	}
	
	// TODO: Monster Creation implementation
	public void createMonster(Monster newMonster) {
		if(!isMonsterValid(newMonster)) {
			throw new InvalidRequestException("The monster was provided invalid information");
		}
		
		newMonster.setCreator(scientistService.getSessionScientist());
		Monster createdMonster = monsterDAO.create(newMonster);
		
		if(createdMonster == null) {
			throw new ResourcePersistenceException("The monster could not be persisted");
		}
	}
	
	private boolean isMonsterValid(Monster newMonster) {
		
		if(newMonster == null) return false;
		if(newMonster.getMonsterName() == null || newMonster.getMonsterName().trim().equals("")) return false;
		if(newMonster.getDexterity() == null || newMonster.getDexterity().trim().equals("") || Integer.valueOf(newMonster.getDexterity()) > 20 || Integer.valueOf(newMonster.getDexterity()) < 0) return false;
		return newMonster.getIntelligence() != null || !newMonster.getIntelligence().trim().equals("");
	}
	
	public List<Monster> findMyMonsters(){
		return null;
	}
	
	public List<Monster> findAllMonsters(){
		return null;
	}

}
