package com.productcategory.exceptionalhandling;

public class CategoryNotFoundException extends RuntimeException{
	
	public CategoryNotFoundException(String messege){
		super(messege);
	}
	


}
