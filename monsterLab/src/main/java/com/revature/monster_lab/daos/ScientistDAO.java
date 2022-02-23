package com.revature.monster_lab.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.monster_lab.models.Scientist;


@Repository
public interface ScientistDAO extends CrudRepository<Scientist, String>{

	
	Optional<Scientist> findScientistByEmail(String email);
	Optional<Scientist> findScientistByUsername(String username);
	List<Scientist> findAll();
	
	@Query("from Scientist s where s.username = :username and s.password = :password")
	Scientist findScientistByUsernameAndPassword(String username, String password);
	

}
