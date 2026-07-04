package com.ecom.inventory_service.serviceImpl;

import com.ecom.inventory_service.entities.Inventory;
import com.ecom.inventory_service.exception.ResourceNotFoundException;
import com.ecom.inventory_service.repository.InventoryRepository;
import com.ecom.inventory_service.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {

        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: "+id));
    }

    @Override
    public Inventory updateInventoryById(Inventory inventory, Long id) {

        Inventory updatedInventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: "+id));

        updatedInventory.setProductId(inventory.getProductId());
        updatedInventory.setQuantity(inventory.getQuantity());

        return inventoryRepository.save(updatedInventory);
    }

    @Override
    public void deleteInventory(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: "+id));

        inventoryRepository.delete(inventory);
    }
}
