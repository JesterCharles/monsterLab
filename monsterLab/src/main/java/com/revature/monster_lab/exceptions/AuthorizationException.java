package com.revature.monster_lab.exceptions;

public class AuthorizationException extends RuntimeException {

	public AuthorizationException() {
		super("Unauthorized user, please login or request permissions from admin.");
		// TODO Auto-generated constructor stub
	}

	public AuthorizationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
