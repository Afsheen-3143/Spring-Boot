package com.productcategory.dto.response;

import com.productcategory.entity.Category;

public class ProductRes {
	private Long Id;
	private String name;
	private Double price;
	private Category categoryId;
	public ProductRes(Long id2, String name2, double price2, Long id3) {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

}
