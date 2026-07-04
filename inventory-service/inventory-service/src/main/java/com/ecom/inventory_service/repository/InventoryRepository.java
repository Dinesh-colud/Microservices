package com.ecom.inventory_service.repository;

import com.ecom.inventory_service.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
