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

		Monster newMonster = new Monster(
				monsterRequest.getMonsterName(), 
				monsterRequest.getMosnterType(), 
				monsterRequest.getStrength(), 
				monsterRequest.getDexterity(), 
				monsterRequest.getIntelligence()
			);
		
		Monster createdMonster = monsterDAO.save(newMonster);
		
		if(createdMonster == null) {
			throw new ResourcePersistenceException("The monster could not be persisted");
		}
		
		return true;
	}
	
	
	public List<MonsterResponse> findMyMonsters(){
		return null;
	}
	
	public List<MonsterResponse> findAllMonsters(){
		return null;
	}

}
