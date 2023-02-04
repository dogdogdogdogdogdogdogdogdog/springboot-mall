package com.vincent.springmall.dao;

import com.vincent.springmall.dto.ProductRequest;
import com.vincent.springmall.model.Product;

public interface ProductDao {

    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);


}
