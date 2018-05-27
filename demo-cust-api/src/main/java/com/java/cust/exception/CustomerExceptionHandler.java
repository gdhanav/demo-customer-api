package com.java.cust.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler(value={EmptyResultDataAccessException.class})
	public ResponseEntity<String> handleNotFoundException(HttpRequest request,Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value={Exception.class})
	public ResponseEntity<String> handleProcessingException(HttpRequest request,Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
