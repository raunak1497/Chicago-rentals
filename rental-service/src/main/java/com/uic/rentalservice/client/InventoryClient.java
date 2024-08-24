package com.uic.rentalservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "inventory-service",url = "${inventory.service.url}")
public interface InventoryClient {

    @GetMapping("/inventory/{id}/availability")
    AvailabilityResponse checkIfProductAvailable(@PathVariable("id") String productId);
}
