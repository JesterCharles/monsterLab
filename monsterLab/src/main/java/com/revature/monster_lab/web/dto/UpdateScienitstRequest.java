package com.revature.monster_lab.web.dto;

import java.util.Objects;

import com.revature.monster_lab.models.Scientist;

public class UpdateScienitstRequest {

	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UpdateScienitstRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateScienitstRequest(String id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public UpdateScienitstRequest(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UpdateScienitstRequest [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + "]";
	}
	
	public Scientist getScientist() {
		Scientist scientist = new Scientist();
		scientist.setScientistId(id);
		scientist.setFirstName(firstName);
		scientist.setLastName(lastName);
		scientist.setEmail(email);
		scientist.setPassword(password);
		
		return scientist;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateScienitstRequest other = (UpdateScienitstRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

}
