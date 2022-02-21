package com.revature.monster_lab.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "scientists")
public class Scientist implements Serializable {
	
	// Attributes/Variables
	@Id
	@Column(name="scientist_id")
	private String scientistId;
	
	@Column(name = "first_name", nullable= false, columnDefinition = "VARCHAR CHECK (first_name <> '')")
	private String firstName;
	
	@Column(name = "last_name", nullable= false, columnDefinition = "VARCHAR CHECK (last_name <> '')")
	private String lastName;
	
	@Column(unique = true, nullable= false, columnDefinition = "VARCHAR CHECK (email <> '')")
	private String email;
	
	@Column(unique = true, nullable= false, columnDefinition = "VARCHAR CHECK (username <> '')")
	private String username;
	
	@Column(nullable= false, columnDefinition = "VARCHAR CHECK (password <> '')")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "accout_type", columnDefinition = "VARCHAR DEFAULT 'LOCKED'")
	private AccountType accountType;
	
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Monster> userMonsters;
	
	// Constructor
	public Scientist() {
		super();
	}
	
	public Scientist(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Scientist(String scientistId, String firstName, String lastName, String email, String username,
			String password) {
		super();
		this.scientistId = scientistId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public Scientist(String scientistId, String firstName, String lastName, String email, String username,
			String password, AccountType accountType) {
		super();
		this.scientistId = scientistId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}
	
	
	// Getters & Setters
	public String getScientistId() {
		return scientistId;
	}

	public void setScientistId(String scientistId) {
		this.scientistId = scientistId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<Monster> getUserMonsters() {
		return userMonsters;
	}

	public void setUserMonsters(List<Monster> userMonsters) {
		this.userMonsters = userMonsters;
	}

	// Custom Methods
	public String toFileString() {
		StringBuilder buildFileString = new StringBuilder();
		
		buildFileString.append(scientistId).append(":")
						.append(firstName).append(":")
						.append(lastName).append(":")
						.append(email).append(":")
						.append(username).append(":")
						.append(password);
		return buildFileString.toString();
	}
	
	public void printFromFile(String[] arr) {
		for(String arrV:arr) {
			System.out.println(arrV);
		}
		
	}

	@Override
	public String toString() {
		return "Scientist [scientistId=" + scientistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, scientistId, userMonsters, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scientist other = (Scientist) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(scientistId, other.scientistId) && Objects.equals(userMonsters, other.userMonsters)
				&& Objects.equals(username, other.username);
	}
	
	// Overrides come last
	
	
	public enum AccountType{
		ADMIN, DEV, BASIC, PREMIUM, LOCKED, BANNED
	}
	
}
