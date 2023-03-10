package com.vincent.springmall.dao.impl;

import com.vincent.springmall.Rowmapper.ProductRowmapper;
import com.vincent.springmall.dao.ProductDao;
import com.vincent.springmall.dto.ProductRequest;
import com.vincent.springmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql=" select product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date from product where product_id=:productId ";
        HashMap<String,Object> map=new HashMap<>();
        map.put("productId",productId);

     List<Product> productList =   namedParameterJdbcTemplate.query(sql,map,new ProductRowmapper());

        if(productList.size()>0){
           return productList.get(0);
        }
        return null;
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql="insert into product (product_name,category,image_url,price,stock,description,created_date,last_modified_date) value(:productName,:category,:imageUrl,:price,:stock,:description,:createDate,:lastModifiedDate) ";
        HashMap<String,Object> map=new HashMap<>();
        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());
        map.put("createDate",new Date());
        map.put("lastModifiedDate",new Date());
        KeyHolder keyHolder=new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int productId=keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql=" update product set product_name=:productName,category=:category,image_url=:imageUrl,price=:price,stock=:stock,description=:description,last_modified_date=:lastModifiedDate where product_id=:productId  ";
        HashMap<String,Object> map=new HashMap<>();
        map.put("productId",productId);
        map.put("productName",productRequest.getProductName());
        map.put("category",productRequest.getCategory().toString());
        map.put("imageUrl",productRequest.getImageUrl());
        map.put("price",productRequest.getPrice());
        map.put("stock",productRequest.getStock());
        map.put("description",productRequest.getDescription());
        map.put("lastModifiedDate",new Date());
        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void delProduct(Integer productId) {
        String sql=" delete from product where product_id=:productId  ";
        HashMap<String,Object> map=new HashMap<>();
        map.put("productId",productId);
        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public List<Product> getProducts() {
        String sql=" select product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date from product  ";
        HashMap<String,Object> map=new HashMap<>();

        List<Product> productList =   namedParameterJdbcTemplate.query(sql,map,new ProductRowmapper());
        return productList;
    }
}
