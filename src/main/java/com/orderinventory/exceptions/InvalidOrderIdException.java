package com.orderinventory.exceptions;

public class InvalidOrderIdException extends Exception{
		private String message;

		public InvalidOrderIdException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		
}
