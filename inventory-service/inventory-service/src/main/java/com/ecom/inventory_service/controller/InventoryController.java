package com.ecom.inventory_service.controller;

import com.ecom.inventory_service.entities.Inventory;
import com.ecom.inventory_service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(inventory1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventories = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id){
        Inventory inventory = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory,
                                                     @PathVariable Long id){
        Inventory inventory1 = inventoryService.updateInventoryById(inventory, id);
        return new ResponseEntity<>(inventory1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id){
        inventoryService.deleteInventory(id);

        return ResponseEntity.ok("Inventory deleted successfully!");
    }

}

