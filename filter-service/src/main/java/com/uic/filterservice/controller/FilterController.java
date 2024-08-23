package com.uic.filterservice.controller;

import com.uic.filterservice.collection.Product;
import com.uic.filterservice.service.FilterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {

    private FilterService filterService;

    @GetMapping
    public List<Product> getProducts() {
        return filterService.getAllProducts();
    }

    @GetMapping("/location/{locationId}")
    public List<Product> getProductByLocation(@PathVariable String locationId) {
        return filterService.getProductByLocation(locationId);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(String category) {
        return filterService.getProductsByCategory(category);
    }

    @GetMapping("/type")
    public List<Product> getProductsByType(String type) {
        return filterService.getProductsByType(type);
    }

    @GetMapping("/category-type")
    public List<Product> getProductsByCategoryAndType(String category, String type) {
        return filterService.getProductsByTypeAndCategory( category,  type);
    }

    @GetMapping("/location-category")
    public List<Product> getProductsByLocationAndCategory(String type, String locationId) {
        return filterService.getProductsByLocationAndCategory(type,locationId);
    }

    @GetMapping("/location-type-category")
    public  List<Product> getProductsByLocationAndTypeAndCategory(String type, String category, String locationId) {
        return filterService.getProductsByLocationAndTypeAndCategory(type,category,locationId);
    }
}
