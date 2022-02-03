package com.revature.monster_lab.daos;

import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.util.collections.List;

public class MonsterDAO implements CrudDAO<Monster> {
	
	// TODO: Implement search by creatorID
	public List<Monster> findMonsterByCreatorId(String id){
		return null;
	}

	@Override
	public Monster create(Monster newMonster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Monster> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monster findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Monster updatedMonster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
