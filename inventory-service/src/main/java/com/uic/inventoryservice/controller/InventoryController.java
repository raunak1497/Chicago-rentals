package com.uic.inventoryservice.controller;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Location;
import com.uic.inventoryservice.model.AvailabilityResponse;
import com.uic.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public void addInventoryEntry(@RequestBody Inventory inventory){
        inventoryService.addEntry(inventory);
    }

    @GetMapping
    public List<Inventory> getInventoryList(){
        return inventoryService.getInventoryList();
    }

    @GetMapping("/location/{id}")
    public List<Inventory> getInventoryByLocation(@PathVariable String locationId){
        return inventoryService.getInventoryByLocation(locationId);
    }

    @GetMapping("/product/{code}")
    public List<Inventory> getInventoryByProduct(@PathVariable String prodCode) {
        return inventoryService.getInventoryByProduct(prodCode);
    }

    @PostMapping({"/availability"})
    public AvailabilityResponse checkIfProductAvailable(@RequestBody HashMap<String,Integer> products){
        log.info("Inside checkIfProductAvailable");
        return inventoryService.checkIfProductAvailable(products);
    }

}
