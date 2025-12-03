package com.productcategory.service;

import java.util.List;

import com.productcategory.dto.request.CategoryReq;
import com.productcategory.dto.response.CategoryRes;

public interface CategoryServiceImpl {
	CategoryRes create(CategoryReq req );
	CategoryRes get(Long Id);
	List<CategoryRes>getall();

}
