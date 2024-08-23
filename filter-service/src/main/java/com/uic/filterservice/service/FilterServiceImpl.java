package com.uic.filterservice.service;

import com.uic.filterservice.collection.Product;
import com.uic.filterservice.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterRepository filterRepository;

    @Override
    public List<Product> getAllProducts() {
        return filterRepository.findAll();
    }

    @Override
    public List<Product> getProductByLocation(String locationId) {
        return filterRepository.findProductByLocationId(locationId);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return filterRepository.findProductByCategory(category);
    }

    @Override
    public List<Product> getProductsByType(String type) {
        return filterRepository.findProductByType(type);
    }

    @Override
    public List<Product> getProductsByTypeAndCategory(String category, String type) {
        return filterRepository.findProductsByTypeAndCategory(category,type);
    }

    @Override
    public List<Product> getProductsByLocationAndCategory(String type, String locationId) {
        return filterRepository.findProductsByLocationIdAndCategory(type,locationId);
    }

    @Override
    public List<Product> getProductsByLocationAndTypeAndCategory(String type, String category, String locationId) {
        return filterRepository.findProductsByLocationIdAndTypeAndCategory(type,category,locationId);
    }
}
