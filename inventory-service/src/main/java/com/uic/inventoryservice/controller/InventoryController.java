package com.uic.inventoryservice.controller;

import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.repository.InventoryRepository;
import com.uic.inventoryservice.service.ProductService;
import com.uic.inventoryservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getProductsList() {
        return productService.getProductsList();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id) {
         return productService.getProduct(id);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
        return "Product deleted successfully";
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(id,product);
        return product;
    }
}
