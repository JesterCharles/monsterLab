package com.revature.monster_lab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.models.Scientist;

@Repository
public class MonsterDAO implements CrudDAO<Monster> {

	// TODO: Implement search by creatorID
	public List<Monster> findMonsterByCreatorId(String id) {
		return null;
	}

	@Override
	public Monster create(Monster newMonster) {
		

		return null;
	}

	@Override
	public List<Monster> findAll() {
		
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
