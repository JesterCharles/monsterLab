package com.revature.monster_lab.aspects;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.revature.monster_lab.exceptions.AuthenticationException;
import com.revature.monster_lab.exceptions.AuthorizationException;
import com.revature.monster_lab.exceptions.InvalidRequestException;
import com.revature.monster_lab.exceptions.ResourceNotFoundException;
import com.revature.monster_lab.exceptions.ResourcePersistenceException;
import com.revature.monster_lab.web.dto.ErrorExceptionResponse;



@RestControllerAdvice
public class ErrorExceptionAspect {

	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler({InvalidRequestException.class, UnrecognizedPropertyException.class, MethodArgumentNotValidException.class})
	    public ErrorExceptionResponse handleBadRequests(Exception e) {
	        return new ErrorExceptionResponse(400, e);
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.UNAUTHORIZED)
	    public ErrorExceptionResponse handleAuthenticationException(AuthenticationException e) {
	        return new ErrorExceptionResponse(401, e);
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.FORBIDDEN)
	    public ErrorExceptionResponse handleAuthorizationException(AuthorizationException e) {
	        return new ErrorExceptionResponse(403, e);
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ErrorExceptionResponse handleResourceNotFoundException(ResourceNotFoundException e) {
	        return new ErrorExceptionResponse(404, e);
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorExceptionResponse handleOtherExceptions(Exception e) {
	        e.printStackTrace();
	        return new ErrorExceptionResponse(500, "An internal server exception occurred. Please check the server logs for more info.", e);
	    }

	    @ExceptionHandler
	    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	    public ErrorExceptionResponse handleUnsupportedMediaType(HttpMediaTypeNotSupportedException e) {
	        return new ErrorExceptionResponse(415, e);
	    }
}