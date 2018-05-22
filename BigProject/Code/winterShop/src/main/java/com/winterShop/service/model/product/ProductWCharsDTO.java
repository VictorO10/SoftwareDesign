package com.winterShop.service.model.product;

import com.winterShop.service.model.inventory.InventoryDTO;
import com.winterShop.service.model.order.OrderItemDTO;
import com.winterShop.service.model.product.snowboard.SnowboardCharacteristicsDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ProductWCharsDTO {

    private Long productWCharsId;

    private ProductDTO productDTO;

    private SnowboardCharacteristicsDTO snowboardCharacteristicsDTO;

    private SnowboardBootsCharacteristicsDTO snowboardBootsCharacteristicsDTO;


    protected Set<InventoryDTO> inventoryDTOSet;

    protected Set<OrderItemDTO> orderItemDTOSet;

    public ProductWCharsDTO() {
    }
}
