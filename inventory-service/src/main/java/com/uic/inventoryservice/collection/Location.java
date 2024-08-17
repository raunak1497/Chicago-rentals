package com.uic.inventoryservice.collection;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Location {
    private String address;
    private String city;
    private String zipCode;
}
