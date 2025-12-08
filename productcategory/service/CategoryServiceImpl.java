package com.productcategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategory.dto.request.CategoryReq;
import com.productcategory.dto.response.CategoryRes;
import com.productcategory.entity.Category;
import com.productcategory.exceptionalhandling.CategoryNotFoundException;
import com.productcategory.mapper.CategoryMapper;
import com.productcategory.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public CategoryRes create(CategoryReq req) {
        Category category = mapper.toEntity(req);
        categoryRepo.save(category);
        return mapper.toResponse(category);
    }

    @Override
    public CategoryRes get(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found: " + id));

        return mapper.toResponse(category);
    }

    @Override
    public List<CategoryRes> getAll() {
        return categoryRepo.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
