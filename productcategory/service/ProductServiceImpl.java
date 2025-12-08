package com.productcategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcategory.dto.request.ProductReq;
import com.productcategory.dto.response.ProductRes;
import com.productcategory.entity.Category;
import com.productcategory.entity.Productnew;
import com.productcategory.exceptionalhandling.CategoryNotFoundException;
import com.productcategory.exceptionalhandling.ProductNotFoundException;
import com.productcategory.mapper.ProductMapper;
import com.productcategory.repository.CategoryRepo;
import com.productcategory.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productrepo;

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private CategoryRepo categoryrepo;

    @Override
    public ProductRes create(ProductReq req) {
        Category category = categoryrepo.findById(req.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found: " + req.getCategoryId()));

        Productnew product = mapper.toEntity(req, category);

        productrepo.save(product);
        return mapper.toResponse(product);
    }

    @Override
    public ProductRes get(Long id) {
        Productnew product = productrepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found " + id));
        return mapper.toResponse(product);
    }

    @Override
    public List<ProductRes> getAll() {
        return productrepo.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
