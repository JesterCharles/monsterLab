package com.revature.monster_lab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.monster_lab.daos.MonsterDAO;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.web.dto.MonsterRequest;
import com.revature.monster_lab.web.dto.MonsterResponse;

@Service
public class MonsterService {
	
	private final MonsterDAO monsterDAO;
	
	public MonsterService(MonsterDAO monsterDAO) {
		this.monsterDAO = monsterDAO;
	}
	
	public boolean createMonster(MonsterRequest monsterRequest) {
		if(!isMonsterValid(monsterRequest)) {
			throw new InvalidRequestException("The monster was provided invalid information");
		}
		
		Monster newMonster = new Monster(
				monsterRequest.getMonsterName(), 
				monsterRequest.getMosnterType(), 
				monsterRequest.getStrength(), 
				monsterRequest.getDexterity(), 
				monsterRequest.getIntelligence()
			);
		
		Monster createdMonster = monsterDAO.create(newMonster);
		
		if(createdMonster == null) {
			throw new ResourcePersistenceException("The monster could not be persisted");
		}
		
		return true;
	}
	
	private boolean isMonsterValid(MonsterRequest newMonster) {
		
		if(newMonster == null) return false;
		if(newMonster.getMonsterName() == null || newMonster.getMonsterName().trim().equals("")) return false;
		if(newMonster.getDexterity() == null || newMonster.getDexterity().trim().equals("") || Integer.valueOf(newMonster.getDexterity()) > 20 || Integer.valueOf(newMonster.getDexterity()) < 0) return false;
		return newMonster.getIntelligence() != null && !newMonster.getIntelligence().trim().equals("");
	}
	
	public List<MonsterResponse> findMyMonsters(){
		return null;
	}
	
	public List<MonsterResponse> findAllMonsters(){
		return null;
	}

}
