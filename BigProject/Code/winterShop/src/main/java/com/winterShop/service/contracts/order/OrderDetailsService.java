package com.winterShop.service.contracts.order;

import com.winterShop.service.contracts.AbstractService;
import com.winterShop.service.model.order.OrderDetailsDTO;
import com.winterShop.service.model.order.ShoppingCartDTO;

import java.util.Set;

public interface OrderDetailsService extends AbstractService<OrderDetailsDTO, Long> {

    OrderDetailsDTO saveWithShoppingCart(ShoppingCartDTO shoppingCartDTO);

    Set<OrderDetailsDTO> getByLoggedInUser();
}
