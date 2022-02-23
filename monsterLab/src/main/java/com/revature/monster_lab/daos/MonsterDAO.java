package com.revature.monster_lab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.monster_lab.models.Monster;
import com.revature.monster_lab.models.Scientist;

@Repository
public interface MonsterDAO extends CrudRepository<Monster, String> {

	
	
}
