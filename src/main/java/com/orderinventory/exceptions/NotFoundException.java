
package com.orderinventory.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}


public static class CustomerNotFoundException extends NotFoundException {
	 
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

public static class StoreNotFoundException extends NotFoundException {

    public StoreNotFoundException(String message) {
        super(message);
    }
}
}
