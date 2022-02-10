package com.revature.monster_lab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.collections.LinkedList;
import com.revature.monster_lab.util.collections.List;
import com.revature.monster_lab.util.datasource.ConnectionFactory;

public class ScientistDAO implements CrudDAO<Scientist> {

	// TODO: Implement Authentication
	public Scientist findByUsernameAndPassword(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from scientists where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Scientist scientist = new Scientist();
				scientist.setScientistId(rs.getString("scientist_id"));
				scientist.setFirstName(rs.getString("first_name"));
				scientist.setLastName(rs.getString("last_name"));
				scientist.setEmail(rs.getString("email"));
				scientist.setUsername(rs.getString("username"));
				scientist.setPassword(rs.getString("password"));

				return scientist;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	// TODO: Implement FindByEmail
	public Scientist findByEmail(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from scientists where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Scientist scientist = new Scientist();
				scientist.setScientistId(rs.getString("id"));
				scientist.setFirstName(rs.getString("first_name"));
				scientist.setLastName(rs.getString("last_name"));
				scientist.setEmail(rs.getString("email"));
				scientist.setUsername(rs.getString("username"));
				scientist.setPassword(rs.getString("password"));

				return scientist;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	// TODO: Implement FindByUsername
	public Scientist findByUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from scientists where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Scientist scientist = new Scientist();
				scientist.setScientistId(rs.getString("id"));
				scientist.setFirstName(rs.getString("first_name"));
				scientist.setLastName(rs.getString("last_name"));
				scientist.setEmail(rs.getString("email"));
				scientist.setUsername(rs.getString("username"));
				scientist.setPassword(rs.getString("password"));

				return scientist;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Scientist create(Scientist newScientist) {

		// Try-with-resources because the connection is AutoClosable
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Set the PK value in java to be added to my data
			// Unique 128-bit string
			newScientist.setScientistId(UUID.randomUUID().toString());

			// The ? are to be added later using the PreparedStatement objects
			// .set{DataType}
			String sql = "insert into scientists (scientist_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			// Adjusted the PreparedStatement to appropriate fill in the ? and execute the
			// SQL statement
			ps.setString(1, newScientist.getScientistId());
			ps.setString(2, newScientist.getFirstName());
			ps.setString(3, newScientist.getLastName());
			ps.setString(4, newScientist.getEmail());
			ps.setString(5, newScientist.getUsername());
			ps.setString(6, newScientist.getPassword());

			// Used ExecuteUpdate to perform DML (Insert, UPdate, Delete)
			int rowsInserted = ps.executeUpdate();

			// Checking that the update Inddeed occured
			if (rowsInserted != 0) {
				return newScientist;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Scientist> findAll() {

		List<Scientist> scientistsList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from scientists";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Scientist scientist = new Scientist();
				scientist.setScientistId(resultSet.getString("scientist_id"));
				scientist.setFirstName(resultSet.getString("first_name"));
				scientist.setLastName(resultSet.getString("last_name"));
				scientist.setEmail(resultSet.getString("email"));
				scientist.setUsername(resultSet.getString("username"));
				scientist.setPassword(resultSet.getString("password"));

				scientistsList.add(scientist);
			}

			return scientistsList;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Scientist findById(String id) {

		// Try-with-resources because the connection is AutoClosable
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// The ? are to be added later using the PreparedStatement objects
			// .set{DataType}
			String sql = "select * from scientists where scientist_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			// Updaet our sql
			ps.setString(1, id);

			// Used ExecuteQuery for selection, and returns a table of what was selected
			
			// Result Set is using a HASHMAP!!!!!!!! WOOOOO :"D
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Scientist idScientist = new Scientist();
				
				// result set .getSTring or get{datatype} 
				// 
				idScientist.setScientistId(rs.getString("scientist_id"));
				idScientist.setFirstName(rs.getString("first_name"));
				idScientist.setLastName(rs.getString("last_name"));
				idScientist.setEmail(rs.getString("email"));
				idScientist.setUsername(rs.getString("username"));;
				idScientist.setPassword(rs.getString("password"));
				
				return idScientist;	
			}


		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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
