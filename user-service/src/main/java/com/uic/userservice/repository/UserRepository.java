package com.uic.userservice.repository;

import com.uic.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // You can define custom query methods here, e.g., find by email
    User findByEmail(String email);
}