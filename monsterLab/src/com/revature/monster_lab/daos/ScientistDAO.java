package com.revature.monster_lab.daos;

import java.io.File;
import java.io.FileWriter;

import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.List;

public class ScientistDAO implements CrudDAO<Scientist> {

	@Override
	public Scientist create(Scientist newScientist) {
		
		File scientistsFile = new File("/monsterLab/src/com/revature/resources/data.txt");
		
		try(FileWriter fileWriter = new FileWriter(scientistsFile, true);) {
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
