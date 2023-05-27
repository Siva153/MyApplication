package org.application.exception;

public class MovieNotFoundException extends RuntimeException {

	public MovieNotFoundException(String message){
		super(message);
	}
}
