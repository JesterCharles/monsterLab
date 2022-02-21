package com.revature.monster_lab.daos;

import java.util.List;

import com.revature.monster_lab.models.Scientist;

public class ScientistDAO implements CrudDAO<Scientist> {

	public Scientist findByUsernameAndPassword(String username, String password) {
		return null;
	}

	public Scientist findByEmail(String email) {
		return null;
	}

	public Scientist findByUsername(String username) {
		return null;
	}

	@Override
	public Scientist create(Scientist newScientist) {
		return null;
	}

	@Override
	public List<Scientist> findAll() {
		return null;
	}

	@Override
	public Scientist findById(String id) {
		return null;
	}

	@Override
	public boolean update(Scientist updatedObj) {
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

}
