package com.uic.rentalservice.client;

import com.uic.rentalservice.model.Rental;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service",url = "${payment.service.url}")
public interface PaymentClient {

    @PostMapping("/payments/process")
    PaymentResponse processRentalPayment(@RequestBody Rental rental);
}
