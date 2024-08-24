package com.uic.paymentservice.service;

import com.uic.paymentservice.collection.CreditCardDetails;
import com.uic.paymentservice.collection.Payment;

import java.util.List;

public interface PaymentService  {
    void addPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(String id);

    boolean verifyCardDetails(CreditCardDetails cardDetails);

    boolean validatePayment(Payment payment);

}
