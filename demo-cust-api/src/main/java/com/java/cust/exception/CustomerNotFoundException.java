package com.java.cust.exception;

/**
 * @author Dhana
 *
 */
public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}

}
