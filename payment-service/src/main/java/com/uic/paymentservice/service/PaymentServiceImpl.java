package com.uic.paymentservice.service;

import com.uic.paymentservice.collection.CreditCardDetails;
import com.uic.paymentservice.collection.Payment;
import com.uic.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String paymentId) {
        return (Payment) paymentRepository.findByPaymentId(paymentId);
    }

    @Override
    public boolean verifyCardDetails(CreditCardDetails cardDetails) {
        return        isValidLength(cardDetails.getCardNumber(), 13, 19) &&
                isValidLength(cardDetails.getCardCvv(), 3, 4) &&
                isValidLength(cardDetails.getCardExpirationYear(), 4, 4) &&
                isValidLength(cardDetails.getCardExpirationMonth(), 1, 2);
    }

    @Override
    public boolean validatePayment(Payment payment) {
        // Validate if the price is less than or equal to the balance
        return payment.getPrice() != null && payment.getBalance() >= payment.getPrice();
    }

    private boolean isValidLength(String value, int minLength, int maxLength) {
        return value != null && value.length() >= minLength && value.length() <= maxLength;
    }
}
