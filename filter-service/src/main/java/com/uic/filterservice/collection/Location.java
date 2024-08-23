package com.uic.filterservice.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Location {
    @Id
    private String locationId;
    private String address;
    private String city;
    private String zipCode;
}
