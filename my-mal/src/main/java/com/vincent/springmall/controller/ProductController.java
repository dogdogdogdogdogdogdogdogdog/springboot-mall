package com.vincent.springmall.controller;

import com.vincent.springmall.model.Product;
import com.vincent.springmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
