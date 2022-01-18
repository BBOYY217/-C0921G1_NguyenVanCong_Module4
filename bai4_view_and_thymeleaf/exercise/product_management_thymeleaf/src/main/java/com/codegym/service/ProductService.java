package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product>  productObj;
    static {
        productObj = new HashMap<>();
        productObj.put(1,new Product(1,"Rog",1000,"gaming","Asus"));
        productObj.put(2,new Product(2,"BlackShank",1000,"gaming","Xiaomi"));
        productObj.put(3,new Product(3,"Iphone13",1000,"phone","Xiaomi"));
        productObj.put(4,new Product(4,"SamsungS21",1000,"phone","Samsung"));
        productObj.put(5,new Product(5,"Sony xperia pro-i",1000,"phone","sony"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productObj.values());
    }

    @Override
    public void save(Product product) {
        productObj.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productObj.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productObj.put(id,product);
    }

    @Override
    public void remove(int id) {
        productObj.remove(id);
    }
}
