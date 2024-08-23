package com.uic.rentalservice.repository;

import com.uic.rentalservice.model.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
}
