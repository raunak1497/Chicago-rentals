package com.uic.inventoryservice.service;

import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Product;
import com.uic.inventoryservice.model.AvailabilityResponse;
import com.uic.inventoryservice.repository.InventoryRepository;
import com.uic.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public AvailabilityResponse checkIfProductAvailable(String id) {

        Product product = productRepository.findById(id)
                .orElse(null);
        if (product == null) {
            return new AvailabilityResponse(false, "Product not found");
        }
        Inventory inventory = inventoryRepository.findByProductCode(product.getProdCode());
        boolean isAvailable = inventory != null && inventory.getQuantity() > 0;
        String message = isAvailable ? "Product is available" : "Product is not available";

        AvailabilityResponse response = new AvailabilityResponse();
        response.setSuccess(isAvailable);
        response.setMessage(message);

        return response;
    }

//    @Override
//    public void sellProductFromInventory(String id) {
//       inventoryRepository.sellProductFromInventory(id);
//    }


}
