package com.revature.banking_app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.banking_app.models.Account;
import com.revature.banking_app.models.User;
import com.revature.banking_app.util.collections.LinkedList;
import com.revature.banking_app.util.collections.List;
import com.revature.banking_app.util.datasource.ConnectionFactory;

public class AccountDAO implements CrudDAO<Account> {
	
	// TODO: Implement search by creatorID
	public List<Account> findAccountByCreatorId(String id){
		List<Account> accountsList = new LinkedList<>(); 
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from accounts where creator_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				Account account = new Account();
				account.setAccountId(resultSet.getString("account_id"));
				account.setAccountName(resultSet.getString("account_name"));
				account.setDollars(resultSet.getInt("account_dollars"));
				account.setCents(resultSet.getInt("account_cents"));
				
				accountsList.add(account);
			}	
			
			return accountsList;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Account create(Account newAccount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			newAccount.setAccountId(UUID.randomUUID().toString());

			String sql = "insert into accounts (account_id, account_name, account_dollars, account_cents, creator_id) values (?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newAccount.getAccountId());
			ps.setString(2, newAccount.getAccountName());
			ps.setInt(3, newAccount.getDollars());
			ps.setInt(4, newAccount.getCents());
			ps.setString(5, newAccount.getCreator().getUserId());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newAccount;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> findAll() {
		return null;
	}

	@Override
	public Account findById(String id) {
		this.findAccountByCreatorId(id);
		return null;
	}

	@Override
	public boolean update(Account updatedAccount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "update accounts set account_dollars = ?, account_cents = ? where account_id = ? and creator_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
	
			ps.setInt(1, updatedAccount.getDollars());
			ps.setInt(2, updatedAccount.getCents());
			ps.setString(3, updatedAccount.getAccountId());
			ps.setString(4, updatedAccount.getCreator().getUserId());
			
			int rowsInserted = ps.executeUpdate();
	
			if (rowsInserted != 0) {
				return true;
			}
	
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}