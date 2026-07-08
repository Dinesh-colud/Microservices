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
    public Inventory getInventoryByProductId(Long productId) {

        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with productId: "+ productId));
    }

    @Override
    public Inventory updateInventoryById(Inventory inventory, Long productId) {

        Inventory updatedInventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with productId: "+ productId));

        updatedInventory.setProductId(inventory.getProductId());
        updatedInventory.setQuantity(inventory.getQuantity());

        return inventoryRepository.save(updatedInventory);
    }

    @Override
    public void deleteInventory(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with productId: "+ productId));

        inventoryRepository.delete(inventory);
    }

    @Override
    public Inventory reduceStock(Long productId, Integer quantity) {

        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with productId: "+productId));

        if(inventory.getQuantity() >= quantity){
            inventory.setQuantity(inventory.getQuantity() - quantity);
            return inventoryRepository.save(inventory);
        } else {
           throw new ResourceNotFoundException("Insufficient stock available");
        }
    }

}
