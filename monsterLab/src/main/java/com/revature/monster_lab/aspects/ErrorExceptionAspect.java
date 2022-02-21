package com.revature.monster_lab.aspects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.web.dto.ErrorExceptionResponse;



@RestControllerAdvice
public class ErrorExceptionAspect {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorExceptionResponse handleRuntimeException(RuntimeException e) {
		return new ErrorExceptionResponse(500, e);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorExceptionResponse handleException(Exception e) {
		return new ErrorExceptionResponse(500, e);
	}
	
	@ExceptionHandler(ResourcePersistenceException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorExceptionResponse handleResourcePersistanceException(RuntimeException e) {
		return new ErrorExceptionResponse(500, e);
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorExceptionResponse handleInvalidRequestException(RuntimeException e) {
		return new ErrorExceptionResponse(400, e);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorExceptionResponse handleAuthenticationException(RuntimeException e) {
		return new ErrorExceptionResponse(401, e);
	}
}