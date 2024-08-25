package com.uic.rentalservice.service;

import com.uic.rentalservice.Util.PaymentRetryUtil;
import com.uic.rentalservice.client.PaymentClient;
import com.uic.rentalservice.client.InventoryClient;
import com.uic.rentalservice.exception.BusinessException;
import com.uic.rentalservice.model.Rental;
import com.uic.rentalservice.repository.RentalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RentalBusinessRules {

    private final RentalRepository rentalRepository;
    private final InventoryClient inventoryClient;
    private final PaymentClient paymentClient;
    private final PaymentRetryUtil paymentRetryUtil;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    public RentalBusinessRules(RentalRepository rentalRepository, InventoryClient inventoryClient,
                               PaymentClient paymentClient, PaymentRetryUtil paymentRetryUtil) {
        this.rentalRepository = rentalRepository;
        this.inventoryClient = inventoryClient;
        this.paymentClient = paymentClient;
        this.paymentRetryUtil = paymentRetryUtil;
    }

    public void checkIfRentalExists(String id) {
        if (!rentalRepository.existsById(id)) {
            throw new BusinessException("Rental not found");
        }
    }

    public void ensureProductIsAvailable(String productId) throws InterruptedException {
        log.info("Checking if product is available");
        log.info("podcut id is {}", productId);
        var response = inventoryClient.checkIfProductAvailable(productId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }


    public void ensurePaymentIsProcessed(Rental rental) throws InterruptedException {
        boolean paymentSuccessful = paymentRetryUtil.retryPayment(() -> paymentClient.processRentalPayment(rental).isSuccess());
        if (!paymentSuccessful) {
            throw new BusinessException("Payment failed after multiple attempts");
        }
    }
}
