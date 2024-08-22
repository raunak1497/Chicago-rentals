package com.uic.inventoryservice.controller;

import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/product"))
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping()
    public List<Product> getProductsList() {
        return productService.getProductsList();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
        return "Product deleted successfully";
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(id,product);
        return product;
    }
}
