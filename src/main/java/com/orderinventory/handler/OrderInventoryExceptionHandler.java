
package com.orderinventory.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orderinventory.errorresponce.CustomErrorResponse;
import com.orderinventory.exceptions.InvaliddataException;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.exceptions.InvalidCustomerIdException;
import com.orderinventory.exceptions.InvalidOrderIdException;
import com.orderinventory.exceptions.InvalidOrderIdException;

@ControllerAdvice
public class OrderInventoryExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleException(NotFoundException exe) {

		CustomErrorResponse st = new CustomErrorResponse();
		st.setStatus(HttpStatus.NOT_FOUND.value());
		st.setMessage(exe.getMessage());
		st.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<CustomErrorResponse>(st, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value=InvaliddataException.class)
	
	public ResponseEntity<CustomErrorResponse> handleException(Exception exe) {

		CustomErrorResponse st = new CustomErrorResponse();
		st.setStatus(HttpStatus.BAD_REQUEST.value());
		st.setMessage(exe.getMessage());
		st.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<CustomErrorResponse>(st, HttpStatus.BAD_REQUEST);

	}

@ExceptionHandler(value=InvalidOrderIdException.class)
	
	public ResponseEntity<CustomErrorResponse> handleOrderIdExceptions(Exception exe) {

		CustomErrorResponse st = new CustomErrorResponse();
		st.setStatus(HttpStatus.NOT_FOUND.value());
		st.setMessage(exe.getMessage());
		st.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<CustomErrorResponse>(st, HttpStatus.BAD_REQUEST);

	}

@ExceptionHandler(value=InvalidCustomerIdException.class)

public ResponseEntity<CustomErrorResponse> handleCustomerIdExceptions(Exception exe) {

	CustomErrorResponse st = new CustomErrorResponse();
	st.setStatus(HttpStatus.NOT_FOUND.value());
	st.setMessage(exe.getMessage());
	st.setTimestamp(System.currentTimeMillis());

	return new ResponseEntity<CustomErrorResponse>(st, HttpStatus.BAD_REQUEST);

}
	

}
