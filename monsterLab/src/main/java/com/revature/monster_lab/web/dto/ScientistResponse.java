package com.revature.monster_lab.web.dto;

import java.util.Objects;

import com.revature.monster_lab.models.Scientist;

public class ScientistResponse {
	
	private String scientistId;
	private String firstName;
	private String lastName;
	private String username;

	public ScientistResponse(Scientist scientist) {
		this.scientistId = scientist.getScientistId();
		this.firstName = scientist.getFirstName();
		this.lastName = scientist.getLastName();
		this.username = scientist.getUsername();
	}

	public ScientistResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ScientistResponse [scientistId=" + scientistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, scientistId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScientistResponse other = (ScientistResponse) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(scientistId, other.scientistId) && Objects.equals(username, other.username);
	}
	
	

}
