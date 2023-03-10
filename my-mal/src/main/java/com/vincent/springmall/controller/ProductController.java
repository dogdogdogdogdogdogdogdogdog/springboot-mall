package com.vincent.springmall.controller;

import com.vincent.springmall.dto.ProductRequest;
import com.vincent.springmall.model.Product;
import com.vincent.springmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
     List<Product> products =  productService.getProducts();

        return ResponseEntity.status(HttpStatus.OK).body(products);


    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody  @Valid ProductRequest productRequest){

        Integer productId=productService.createProduct(productRequest);
        Product product=productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody @Valid ProductRequest productRequest){
      Product product =  productService.getProductById(productId);
        if( product!=null){
            productService.updateProduct(productId,productRequest);
            product=productService.getProductById(productId);
            return  ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId){
        Product product=productService.getProductById(productId);
        if(product!=null){
            productService.delProduct(productId);
            return  ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
