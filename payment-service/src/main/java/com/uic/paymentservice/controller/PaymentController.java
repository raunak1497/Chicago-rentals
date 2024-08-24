package com.uic.paymentservice.controller;

import com.uic.paymentservice.collection.CreditCardDetails;
import com.uic.paymentservice.collection.Payment;
import com.uic.paymentservice.model.PaymentResponse;
import com.uic.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping
    public void addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
    }

    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/validatePayment")
    public PaymentResponse validatePayment(@RequestBody Payment payment) {

        return paymentService.validatePayment(payment);

    }

    @PostMapping("/verifyCardDetails")
    public boolean verifyCardDetails(@RequestBody CreditCardDetails cardDetails){
        return paymentService.verifyCardDetails(cardDetails);
    }
}
