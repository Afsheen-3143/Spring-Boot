package com.productcategory.service;

import java.util.List;
import com.productcategory.dto.request.ProductReq;
import com.productcategory.dto.response.ProductRes;

public interface ProductService {
    ProductRes create(ProductReq req);
    ProductRes get(Long id);
    List<ProductRes> getAll();
}
