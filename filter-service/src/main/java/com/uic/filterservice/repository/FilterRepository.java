package com.uic.filterservice.repository;

import com.uic.filterservice.collection.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterRepository extends MongoRepository<Product, String> {

    List<Product> findProductByLocationId(String locationId);

    List<Product> findProductByCategory(String category);

    List<Product> findProductByType(String type);

    List<Product> findProductsByTypeAndCategory(String category, String type);

    List<Product> findProductsByLocationIdAndCategory(String type, String locationId);

    List<Product> findProductsByLocationIdAndTypeAndCategory(String type, String category, String locationId);
}

