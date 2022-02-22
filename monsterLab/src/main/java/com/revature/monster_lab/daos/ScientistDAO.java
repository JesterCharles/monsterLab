package com.revature.monster_lab.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.monster_lab.models.Scientist;


@Repository
public interface ScientistDAO extends CrudRepository<Scientist, String>{

	
	Scientist findScientistByEmail(String email);
	Scientist findScientistByUsername(String username);
	
	@Query("from Scientist s where s.username = :username and s.password = :password")
	Scientist findScientistByUsernameAndPassword(String username, String password);
	

}
