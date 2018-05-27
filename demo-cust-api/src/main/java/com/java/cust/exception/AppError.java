package com.java.cust.exception;

public class AppError {
	
	public String errorDescription;
	public int statuscode;
	public String msg;
	
	public AppError(String errorDescription,int statuscode,String msg ) {
		this.errorDescription=errorDescription;
		this.statuscode=statuscode;
		this.msg=msg;
	}

	@Override
	public String toString() {
		return "AppError [errorDescription=" + errorDescription + ", statuscode=" + statuscode + ", msg=" + msg + "]";
	}
	

}
