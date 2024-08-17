package com.uic.inventoryservice.repository;

import com.uic.inventoryservice.collection.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Product, String> {

}
