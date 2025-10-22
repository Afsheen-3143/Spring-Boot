package com.ecomm2.ecomm2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm2.ecomm2.Repository.ProductRepository;
import com.ecomm2.ecomm2.common.Product;


@Service
public class ProductService {
	
	
	@Autowired
    private ProductRepository productRepository;

    // Add product
    public Product addproduct(Product p) {
        return productRepository.save(p);
    }

    // Get all products
    public List<Product> getallproducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Product getbyId(int id) {
        Optional<Product> p = productRepository.findById(id);
        return p.orElse(null);
    }

    // Update product
    public Product updatebyId(int id, Product p) {
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isPresent()) {
            Product prod = existing.get();
            prod.setProductName(p.getProductName());
            prod.setProductPrice(p.getProductPrice());
            prod.setProductQuantity(p.getProductQuantity());
            return productRepository.save(prod);
        }
        return null;
    }

    // Delete product by ID
    public boolean deletebyId(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Delete all products
    public void deleteall() {
        productRepository.deleteAll();
    }
}


