package com.uic.rentalservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String rentalId;
    private double totalPrice;
    private String status;
}
