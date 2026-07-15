package com.ecom.order_service.client;

import com.ecom.order_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    InventoryResponse getInventory(@PathVariable Long productId);

    @PutMapping("/api/inventory/reduce/{productId}")
    InventoryResponse reduceStock(@PathVariable Long productId,
                                  @RequestParam Integer quantity);

}
