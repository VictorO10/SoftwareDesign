package com.winterShop.repository.contracts.order;

import com.winterShop.repository.model.order.ShoppingCartLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartLineDAO extends JpaRepository<ShoppingCartLine, Long> {
}
