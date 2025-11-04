package com.cdac.customExceptions;

public class ResourceNotFound extends RuntimeException {
	
	public ResourceNotFound(String mesg) {
		super(mesg);
	}

}
