package com.uic.userservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    private String name;

    public User(String name, long id, String email, long phone, long SSN, String address) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.SSN = SSN;
        this.address = address;
    }

    private long id;

    private String email;

    private long phone;

    private long SSN;

    private String address;

    private List<Product> productList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getSSN() {
        return SSN;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
