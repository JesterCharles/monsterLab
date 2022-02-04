package com.revature.monster_lab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.util.collections.List;
import com.revature.monster_lab.util.datasource.ConnectionFactory;

public class MonsterDAO implements CrudDAO<Monster> {
	
	// TODO: Implement search by creatorID
	public List<Monster> findMonsterByCreatorId(String id){
		return null;
	}

	@Override
	public Monster create(Monster newMonster) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			newMonster.setMonsterId(UUID.randomUUID().toString());

			String sql = "insert into monsters (monster_id, monster_name, monster_type, strength, dexterity, intelligence, creator_id) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newMonster.getMonsterId());
			ps.setString(2, newMonster.getMonsterName());
			ps.setString(3, newMonster.getMonsterType());
			ps.setString(4, newMonster.getStrength());
			ps.setString(5, newMonster.getDexterity());
			ps.setString(6, newMonster.getIntelligence());
			ps.setString(7, newMonster.getCreator().getScientistId());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newMonster;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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
