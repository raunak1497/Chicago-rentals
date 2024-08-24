package com.uic.paymentservice.controller;

import com.uic.paymentservice.collection.CreditCardDetails;
import com.uic.paymentservice.collection.Payment;
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
    public ResponseEntity<String> validatePayment(@RequestBody Payment payment) {
        boolean isValid = paymentService.validatePayment(payment);

        if (isValid) {
            return ResponseEntity.ok("Payment is valid.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment is invalid. Insufficient balance.");
        }
    }

    @PostMapping("/verifyCardDetails")
    public boolean verifyCardDetails(@RequestBody CreditCardDetails cardDetails){
        return paymentService.verifyCardDetails(cardDetails);
    }
}
