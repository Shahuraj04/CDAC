package com.organization.exceptions;

public class ResourceAlreadyExistException  extends RuntimeException{
	String msg;
	public ResourceAlreadyExistException(String msg) {
		super(msg);
	}

}
