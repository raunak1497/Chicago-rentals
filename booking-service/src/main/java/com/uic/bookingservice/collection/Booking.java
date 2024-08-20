package com.uic.bookingservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private String bookingId;
    private String userId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private Double bookingCost;
    private int noOfItems;
//    private List<Product> productList;
    private Status status;
    private String transactionId;
    private Mode paymentMode;
}
