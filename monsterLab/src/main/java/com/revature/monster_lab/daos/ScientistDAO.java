package com.revature.monster_lab.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.ConnectionFactory;
import com.revature.monster_lab.util.List;

public class ScientistDAO implements CrudDAO<Scientist> {

	File scientistsFile = new File("src/main/resources/data.txt");

	// TODO: Implement Authentication
	public Scientist findByUsernameAndPassword(String username, String password) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Scientist create(Scientist newScientist) {

		try (FileWriter fileWriter = new FileWriter(scientistsFile, true);) {
			newScientist.setScientistId(UUID.randomUUID().toString());
			fileWriter.write(newScientist.toFileString() + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error persistin user to file");
		}
		return null;
	}

	@Override
	public List<Scientist> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scientist findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Scientist updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
