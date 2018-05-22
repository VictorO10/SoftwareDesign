package com.winterShop.repository.contracts.inventory;

import com.winterShop.repository.model.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InventoryDAO extends JpaRepository<Inventory, Long> {
}
