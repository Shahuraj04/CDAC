package com.cdac.customExceptions;

public class ResourceAlreadyExistException extends RuntimeException {

	
	public ResourceAlreadyExistException(String mesg) {
		super(mesg);
	}
}
