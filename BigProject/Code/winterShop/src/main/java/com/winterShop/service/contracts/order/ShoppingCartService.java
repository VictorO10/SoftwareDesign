package com.winterShop.service.contracts.order;

import com.winterShop.repository.model.order.ShoppingCart;
import com.winterShop.service.contracts.AbstractService;
import com.winterShop.service.model.order.ShoppingCartDTO;

public interface ShoppingCartService extends AbstractService<ShoppingCartDTO, Long> {

    Long findShoppingCartIdByUserEmail(String email);

    ShoppingCartDTO findShoppingCartByUserEmail(String email);

    ShoppingCartDTO getByLoggedInEmail();
}
