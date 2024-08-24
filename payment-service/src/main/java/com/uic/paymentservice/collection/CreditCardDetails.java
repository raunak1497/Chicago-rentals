package com.uic.paymentservice.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CreditCardDetails {
    @Id
    private String cardNumber;
    private String cardHolder;
    private String cardExpirationYear;
    private String cardExpirationMonth;
    private String cardCvv;
    private double balance;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardExpirationYear(String cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public String getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(String cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
