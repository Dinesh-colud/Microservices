package com.ecom.inventory_service.service;

import com.ecom.inventory_service.entities.Inventory;

import java.util.List;

public interface InventoryService {


    Inventory createInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryById(Long id);

    Inventory updateInventoryById(Inventory inventory, Long id);

    void deleteInventory(Long id);
}
