package com.vincent.springmall.service;

import com.vincent.springmall.dto.ProductRequest;
import com.vincent.springmall.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);
    public void updateProduct(Integer productId,ProductRequest productRequest);
    public void delProduct(Integer productId);
    public List<Product> getProducts();
}
