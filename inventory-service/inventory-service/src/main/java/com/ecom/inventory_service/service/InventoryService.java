package com.ecom.inventory_service.service;

import com.ecom.inventory_service.entities.Inventory;

import java.util.List;

public interface InventoryService {


    Inventory createInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    Inventory getInventoryByProductId(Long productId);

    Inventory updateInventoryById(Inventory inventory, Long productId);

    void deleteInventory(Long productId);


    Inventory reduceStock(Long productId, Integer quantity);
}
