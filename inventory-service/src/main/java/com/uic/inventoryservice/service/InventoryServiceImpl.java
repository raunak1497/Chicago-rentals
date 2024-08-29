package com.uic.inventoryservice.service;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.model.AvailabilityResponse;
import com.uic.inventoryservice.repository.InventoryRepository;
import com.uic.inventoryservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

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
        return inventoryRepository.findByLocationId(locationId);
    }

    @Override
    public List<Inventory> getInventoryByProduct(String prodCode) {
        return inventoryRepository.findAllByProductCode(prodCode);
    }

    @Override
    public AvailabilityResponse checkIfProductAvailable(HashMap<String,Integer> product) {
        AvailabilityResponse response = new AvailabilityResponse();

        boolean success = false;
        String message = null;
        for (String id : product.keySet()) {
            Inventory inventory = inventoryRepository.findByProductCode(id);
            if (inventory == null) {
                success = false;
                message = "No such product in inventory";
            } else if (inventory.getQuantity() < product.get(id)) {
                success = false;
                message = "Not enough quantity for "+inventory.getProdName();
            } else {
                success = true;
                message = "Product available";
            }
        }

        response.setSuccess(success);
        response.setMessage(message);

        return response;
    }

    @KafkaListener(topics = "rental-topic", groupId = "rental-group")
    public void rentProduct(Object product) {
        log.info(String.valueOf("here"));
        log.info(String.valueOf(product));
    }



}
