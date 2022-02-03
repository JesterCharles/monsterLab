package com.revature.monster_lab.daos;

import com.revature.monster_lab.util.List;

public interface CrudDAO<T> {

	// CRUD: Create, Read, Update, Delete

	// Create
	T create(T newObj);
	
	// Read
	List<T> findAll();
	T findById(String id);
	
	// Update
	boolean update(T updatedObj);
	
	// Delete
	boolean delete(String id);
}
