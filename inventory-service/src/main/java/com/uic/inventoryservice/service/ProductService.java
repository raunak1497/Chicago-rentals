package com.uic.inventoryservice.service;

import com.uic.inventoryservice.collection.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getProductsList();

    Product getProduct(String id);

    void deleteById(String id);

    void updateProduct(String id, Product product);
}
