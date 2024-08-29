package com.uic.rentalservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(name = "inventory-service",url = "${inventory.service.url}")
public interface InventoryClient {

    @PostMapping("/inventory/availability")
    AvailabilityResponse checkIfProductAvailable(@RequestBody HashMap<String,Integer> products);
}
