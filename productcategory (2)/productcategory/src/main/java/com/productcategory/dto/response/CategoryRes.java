package com.productcategory.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRes {

	private Long id;
    private String name;
    private List<ProductRes> products;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductRes> getProducts() {
		return products;
	}
	public void setProducts(List<ProductRes> products) {
		this.products = products;
	}
	public CategoryRes(Long id, String name, List<ProductRes> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
    
}
