package com.productcategory.service;

import java.util.List;

import com.productcategory.dto.request.CategoryReq;
import com.productcategory.dto.response.CategoryRes;

public interface CategoryService {
    CategoryRes create(CategoryReq req);
    CategoryRes get(Long id);
    List<CategoryRes> getAll();
}
