package main.java.com.revature.monster_lab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

<<<<<<< HEAD
import main.java.com.revature.monster_lab.models.Monster;
import main.java.com.revature.monster_lab.util.collections.List;
import main.java.com.revature.monster_lab.util.datasource.ConnectionFactory;
=======
import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.datasource.ConnectionFactory;
>>>>>>> e15cb32b79c5ab59dce2744207e725dafc1e8e16

public class MonsterDAO implements CrudDAO<Monster> {

	// TODO: Implement search by creatorID
	public List<Monster> findMonsterByCreatorId(String id) {
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
		List<Monster> monsters = new LinkedList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from monsters m join scientists s on m.creator_id = s.scientist_id";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Scientist monsterCreator = new Scientist();

				monsterCreator.setScientistId(rs.getString("scientist_id"));
				monsterCreator.setFirstName(rs.getString("first_name"));
				monsterCreator.setLastName(rs.getString("last_name"));
				monsterCreator.setEmail(rs.getString("email"));
				monsterCreator.setUsername(rs.getString("username"));

				Monster monster = new Monster();

				monster.setMonsterId(rs.getString("monster_id"));
				monster.setMonsterName(rs.getString("monster_name"));
				monster.setMonsterType(rs.getString("monster_type"));
				monster.setStrength(rs.getString("strength"));
				monster.setDexterity(rs.getString("dexterity"));
				monster.setIntelligence(rs.getString("intelligence"));
				monster.setCreator(monsterCreator);

				monsters.add(monster);
			}
			 System.out.println("DAO is returning: " + monsters);
			return monsters;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return monsters;
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
