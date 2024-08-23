package com.uic.inventoryservice.controller;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Location;
import com.uic.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

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
//
//    @PostMapping({"/{id}"})
//    public void sellProductFromInventory(@RequestBody String id){
//        inventoryService.sellProductFromInventory(id);
//    }
}
