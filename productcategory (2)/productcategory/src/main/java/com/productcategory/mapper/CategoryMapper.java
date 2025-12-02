package com.productcategory.mapper;

import java.util.List;

import com.productcategory.dto.request.CategoryReq;
import com.productcategory.dto.response.CategoryRes;
import com.productcategory.dto.response.ProductRes;
import com.productcategory.entity.Category;

public class CategoryMapper {
	public Category toEntity(CategoryReq dto) {
		Category category=new Category();
		category.setName(dto.getName());
		return category;
	}
	  public CategoryRes toResponse(Category category) {
	        List<ProductRes> productResponses = category.getProducts()
	                .stream()
	                .map(p -> new ProductRes(
	                        p.getId(), p.getName(), p.getPrice(), category.getId()
	                ))
	                .toList();

	        return new CategoryRes(
	                category.getId(),
	                category.getName(),
	                productResponses
	        );
	    }
	}
