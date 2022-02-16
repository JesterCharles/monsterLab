package main.java.com.revature.monster_lab.daos;

<<<<<<< HEAD
import main.java.com.revature.monster_lab.util.collections.List;
=======
import java.util.List;
>>>>>>> e15cb32b79c5ab59dce2744207e725dafc1e8e16

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
