package com.vincent.springmall.dao;

import com.vincent.springmall.dto.ProductRequest;
import com.vincent.springmall.model.Product;

import java.util.List;

public interface ProductDao {

    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);
    public void updateProduct(Integer productId,ProductRequest productRequest);
    public void delProduct(Integer productId);
    public List<Product> getProducts();
}
