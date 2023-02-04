package com.vincent.springmall.dao.impl;

import com.vincent.springmall.Rowmapper.ProductRowmapper;
import com.vincent.springmall.dao.ProductDao;
import com.vincent.springmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

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
}
