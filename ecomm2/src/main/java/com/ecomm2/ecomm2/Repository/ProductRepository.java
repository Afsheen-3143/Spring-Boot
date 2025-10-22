package com.ecomm2.ecomm2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm2.ecomm2.common.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

