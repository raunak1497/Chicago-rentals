package com.uic.paymentservice.repository;

import com.uic.paymentservice.collection.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByPaymentId(String paymentId);
}
