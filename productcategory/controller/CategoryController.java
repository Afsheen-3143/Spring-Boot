package com.productcategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcategory.dto.request.CategoryReq;
import com.productcategory.dto.response.CategoryRes;
import com.productcategory.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {



	    @Autowired
	    private CategoryService service;

	    @PostMapping
	    public CategoryRes create(@RequestBody @Valid CategoryReq request) {
	        return service.create(request);
	    }

	    @GetMapping("/{id}")
	    public CategoryRes get(@PathVariable Long id) {
	        return service.get(id);
	    }

	    @GetMapping
	    public List<CategoryRes> getAll() {
	        return service.getAll();
	    }
	}


