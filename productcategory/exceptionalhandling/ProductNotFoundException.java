package com.productcategory.exceptionalhandling;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String messege) {
		super(messege);
	}

}
