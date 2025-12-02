package com.productcategory.exceptionalhandling;

public class ErrorResponse {

	private int status;
	private String messege;
	public ErrorResponse(int status, String messege) {
		super();
		this.status = status;
		this.messege = messege;
	}
	
}
