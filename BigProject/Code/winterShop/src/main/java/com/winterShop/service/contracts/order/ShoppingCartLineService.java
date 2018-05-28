package com.winterShop.service.contracts.order;

import com.winterShop.service.contracts.AbstractService;
import com.winterShop.service.model.order.ShoppingCartLineDTO;

public interface ShoppingCartLineService extends AbstractService<ShoppingCartLineDTO, Long> {

    ShoppingCartLineDTO save(Long productWCharsId);
}
