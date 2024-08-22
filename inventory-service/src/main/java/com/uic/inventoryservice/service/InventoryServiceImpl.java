package com.uic.inventoryservice.service;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Location;
import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void addEntry(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getInventoryList() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<Inventory> getInventoryByLocation(String locationId) {
        return inventoryRepository.findByLocation(locationId);
    }

    @Override
    public List<Inventory> getInventoryByProduct(String prodCode) {
        return inventoryRepository.findByProduct(prodCode);
    }

    @Override
    public void sellProductFromInventory(String id) {
       inventoryRepository.sellProductFromInventory(id);


    }


}
