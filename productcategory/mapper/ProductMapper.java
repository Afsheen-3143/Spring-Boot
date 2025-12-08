package com.productcategory.mapper;

import org.springframework.stereotype.Component;


import com.productcategory.dto.request.ProductReq;
import com.productcategory.dto.response.ProductRes;
import com.productcategory.entity.Category;
import com.productcategory.entity.Productnew;


@Component
public class ProductMapper {

    public Productnew toEntity(ProductReq dto, Category category) {
        Productnew p = new Productnew();
      p.setName(dto.getName());
      p.setPrice(dto.getPrice());
      p.setCategory(category);
      return p;
    }
    public ProductRes toResponse(Productnew product) {
        return new ProductRes(
        		product.getId(),
        		  product.getName(),
                  product.getPrice(),
                  product.getCategory().getId()
        );
    
}


}
