package com.uic.filterservice.service;

import com.uic.filterservice.collection.Product;

import java.util.List;

public interface FilterService
{
    List<Product> getAllProducts();

    List<Product> getProductByLocation(String locationId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByType(String type);

    List<Product> getProductsByTypeAndCategory(String category, String type);

    List<Product> getProductsByLocationAndCategory(String type, String locationId);

    List<Product> getProductsByLocationAndTypeAndCategory(String type, String category, String locationId);
}