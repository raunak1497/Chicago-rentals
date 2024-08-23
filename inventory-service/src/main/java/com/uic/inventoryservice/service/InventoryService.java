package com.uic.inventoryservice.service;


import com.uic.inventoryservice.collection.Inventory;
import com.uic.inventoryservice.collection.Location;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> getInventoryList();

    void addEntry(Inventory inventory);

    List<Inventory> getInventoryByLocation(String locationId);

    List<Inventory> getInventoryByProduct(String prodCode);

//    void sellProductFromInventory(String id);
}
