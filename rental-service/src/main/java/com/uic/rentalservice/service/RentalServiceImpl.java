package com.uic.rentalservice.service;

import com.uic.rentalservice.exception.RentalNotFoundException;
import com.uic.rentalservice.model.Invoice;
import com.uic.rentalservice.model.Rental;
import com.uic.rentalservice.repository.InvoiceRepository;
import com.uic.rentalservice.repository.RentalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalBusinessRules rentalBusinessRules;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, RentalBusinessRules rentalBusinessRules, InvoiceRepository invoiceRepository) {
        this.rentalRepository = rentalRepository;
        this.rentalBusinessRules = rentalBusinessRules;
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(String rentalId) {
        return rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found"));
    }

    @Override
    public Rental addRental(Rental rental) throws InterruptedException{
        //Check product availability
        log.info("rental id is {}", rental.getId());
        rentalBusinessRules.ensureProductIsAvailable(rental.getId());

        //Process payment
        rentalBusinessRules.ensurePaymentIsProcessed(rental);

        //Generate rental details
        rental.setRentedAt(LocalDate.now());
        rental.setTotalPrice(rental.getDailyPrice() * rental.getRentedForDays());
        Rental savedRental = rentalRepository.save(rental);

        //Generate invoice
        Invoice invoice = new Invoice();
        invoice.setRentalId(savedRental.getId());
        invoice.setTotalPrice(savedRental.getTotalPrice());
        invoice.setStatus("PAID");
        invoiceRepository.save(invoice);

        return savedRental;
    }

    @Override
    public Rental updateRental(String id, Rental rental) {
        rentalBusinessRules.checkIfRentalExists(id);
        rental.setId(id);
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteRental(String id) {
        rentalBusinessRules.checkIfRentalExists(id);
        rentalRepository.deleteById(id);
    }
}
