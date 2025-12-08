package com.productcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcategory.entity.Productnew;

public interface ProductRepo extends JpaRepository<Productnew,Long>{
	

}
