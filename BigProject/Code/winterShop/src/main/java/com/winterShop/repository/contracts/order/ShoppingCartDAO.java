package com.winterShop.repository.contracts.order;

import com.winterShop.repository.model.order.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartDAO extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart findShoppingCart_shoppingCartIdByUser_email(String email);
}
