package com.uic.inventoryservice.repository;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Location;
import com.uic.inventoryservice.collection.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
    List<Inventory> findByLocationId(String locationId);
    List<Inventory> findByProductCode(String prodCode);


//    @Query(value = "{ '_id': ?0 }", update = "{ '$inc': { 'quantity': ?1 } }")
//    void sellProductFromInventory(String id);
}
