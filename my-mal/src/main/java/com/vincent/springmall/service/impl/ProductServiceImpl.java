package com.vincent.springmall.service.impl;

import com.vincent.springmall.dao.ProductDao;
import com.vincent.springmall.model.Product;
import com.vincent.springmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private  ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}