package com.revature.banking_app.models;

public class Account {
	private String accountId;
	private String accountName;
	private int dollars;
	private int cents;
	private User creator;
	
	
	// Boilerplate 
	public Account() {
		super();
	}

	public Account(String accountId, String accountName, String initialDeposit, User creator) {
		super();

		String depositArray[] = initialDeposit.split("\\.");
		
		this.accountId = accountId;
		this.accountName = accountName;
		this.dollars = Integer.parseInt(depositArray[0]);
		this.cents = Integer.parseInt(depositArray[1]);
		this.creator = creator;
	}
	
	public Account(String accountId, String accountName, int dollars, int cents, User creator) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.dollars = dollars;
		this.cents = cents;
		this.creator = creator;
	}
	
	/*public Account(String accountName, int dollars, int cents, User creator) {
		super();
		this.accountName = accountName;
		this.dollars = dollars;
		this.cents = cents;
		this.creator = creator;
	}*/

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getDollars() {
		return this.dollars;
	}
	
	public void setDollars(int dollars) {
		this.dollars = dollars;
	}
	
	public int getCents() {
		return this.cents;
	}
	
	public void setCents(int cents) {
		this.cents = cents;
	}
	
	/*public String getAccountBalance() {
		return Integer.toString(dollars)+"."+Integer.toString(cents);
	}*/

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
}