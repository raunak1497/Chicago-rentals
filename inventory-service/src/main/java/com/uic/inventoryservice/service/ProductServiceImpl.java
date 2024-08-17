package com.uic.inventoryservice.service;

import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override()
    public Product addProduct(Product product) {
         return inventoryRepository.save(product);
    }

    @Override
    public List<Product> getProductsList() {
        return inventoryRepository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public void updateProduct(String id,Product product){
        Product prod = inventoryRepository.findById(id).get();

        if(Objects.nonNull(prod.getProductName()) &&
                !"".equalsIgnoreCase(prod.getProductName()) ){
            prod.setProductName(product.getProductName());
        }

        if(Objects.nonNull(prod.getProductPrice()) ){
            prod.setProductPrice(product.getProductPrice());
        }

        inventoryRepository.save(prod);
    }
}
