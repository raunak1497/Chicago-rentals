package com.uic.rentalservice.controller;

import com.uic.rentalservice.model.Rental;
import com.uic.rentalservice.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {


    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental) throws InterruptedException {
        Rental createdRental = rentalService.addRental(rental);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<Rental> getRentalById(@PathVariable String rentalId) {
        Rental rental = rentalService.getRentalById(rentalId);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @PutMapping("/{rentalId}")
    public ResponseEntity<Rental> updateRental(@PathVariable String rentalId, @RequestBody Rental rental) {
        Rental updatedRental = rentalService.updateRental(rentalId, rental);
        return new ResponseEntity<>(updatedRental, HttpStatus.OK);
    }

    @DeleteMapping("/{rentalId}")
    public ResponseEntity<Void> deleteRental(@PathVariable String rentalId) {
        rentalService.deleteRental(rentalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
