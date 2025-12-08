package com.productcategory.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class CategoryReq {
	
	 @NotBlank
	    private String name;

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }
	 
}
