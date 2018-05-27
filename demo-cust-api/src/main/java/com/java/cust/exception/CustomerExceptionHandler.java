package com.java.cust.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler(value={CustomerNotFoundException.class})
	public ResponseEntity<AppError> handleNotFoundException(Exception ex){
		AppError error = new AppError(ex.getMessage(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(value={CustomerException.class})
	public ResponseEntity<AppError> handleProcessingException(Exception ex){
		AppError error = new AppError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
