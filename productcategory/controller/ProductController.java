package com.productcategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcategory.dto.request.ProductReq;
import com.productcategory.dto.response.ProductRes;
import com.productcategory.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	  @PostMapping
	    public ProductRes create(@RequestBody @Valid ProductReq request) {
	        return productservice.create(request);
	    }

	    @GetMapping("/{id}")
	    public ProductRes get(@PathVariable Long id) {
	        return productservice.get(id);
	    }

	    @GetMapping
	    public List<ProductRes> getAll() {
	        return productservice.getAll();
	    }

}
