package com.orderinventory.exceptions;

public class InvalidCustomerIdException extends Exception{
	private String message;

	public InvalidCustomerIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
