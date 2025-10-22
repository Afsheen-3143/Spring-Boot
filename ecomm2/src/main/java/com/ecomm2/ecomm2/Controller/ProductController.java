package com.ecomm2.ecomm2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm2.ecomm2.common.Product;
import com.ecomm2.ecomm2.service.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
	@GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getallproducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product p = productService.getbyId(id);
        if (p == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    // Add new product
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        Product saved = productService.addproduct(p);
        return ResponseEntity.ok(saved);
    }

    // Update product by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product p) {
        Product updated = productService.updatebyId(id, p);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Delete product by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean deleted = productService.deletebyId(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Product deleted successfully with ID: " + id);
    }

    // Delete all products
    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAllProducts() {
        productService.deleteall();
        return ResponseEntity.ok("All products deleted successfully");
    }
}
