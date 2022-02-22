package com.revature.monster_lab.exceptions;

public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException() {
		super("No resource found using the provided criteria");
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
