package com.uic.paymentservice.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
@Data
public class Payment {
    @Id
    private String paymentId;
    private String rentalId;
    private Double price;
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String cardCvv;
    private double balance;

}
