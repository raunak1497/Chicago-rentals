package com.uic.paymentservice.service;

import com.uic.paymentservice.collection.CreditCardDetails;
import com.uic.paymentservice.collection.Payment;
import com.uic.paymentservice.model.PaymentResponse;
import com.uic.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
    public PaymentResponse validatePayment(Payment payment) {
        // Validate if the price is less than or equal to the balance
        //add payment id
        //verify card
        // check bal
        log.info("Validate payment {}", payment);
        PaymentResponse paymentResponse = new PaymentResponse();
        if(payment.getTotalPrice() != null){
            paymentResponse.setMessage("payment success!");
            paymentResponse.setSuccess(true);
        }else{
            paymentResponse.setMessage("payment failed!");
            paymentResponse.setSuccess(false);
        }
        return paymentResponse;
    }

    private boolean isValidLength(String value, int minLength, int maxLength) {
        return value != null && value.length() >= minLength && value.length() <= maxLength;
    }
}
