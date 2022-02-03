package com.revature.monster_lab.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		// Using .properties for DB credentials (this is to obfuscate)
		try {
			prop.load(new FileReader("src/main/resources/db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("admin"),prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	

}
