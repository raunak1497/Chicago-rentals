package com.uic.rentalservice.service;

import com.uic.rentalservice.model.Rental;

import java.util.List;

public interface RentalService {
    Rental addRental(Rental rental) throws InterruptedException;
    List<Rental> getAllRentals();
    Rental getRentalById(String rentalId);
    Rental updateRental(String id, Rental rental);
    void deleteRental(String id);
}
