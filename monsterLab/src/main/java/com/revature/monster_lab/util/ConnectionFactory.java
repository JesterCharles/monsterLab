package com.revature.monster_lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * Singleton Design Pattern
 * 	- Creational Pattern
 *  - Restricts that only a single instance of this class can be made within the application
 *  - Constructor cannot be invoked outside of the class
 *  - Eager or lazy singletons
 *  
 * Factory Design Pattern
 * 	- Creational Pattern
 * 	- used to abstract away the creation/instantiate 
 */

public class ConnectionFactory {
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties prop = new Properties();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:postgresql://monster-lab-db-server.postgres.database.azure.com:5432/postgres?currentSchema=monsterlab";
		String admin = "postgres@monster-lab-db-server";
		String password = "charlesP0";
		
		try {
			conn = DriverManager.getConnection(url,admin,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	

}
