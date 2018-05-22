package com.winterShop.service.model.order;


import com.winterShop.service.model.product.ProductWCharsDTO;


public class OrderItemDTO {

    private Long orderItemId;

    private ProductWCharsDTO productWCharsDTO;

    private OrderDetailsDTO orderDetailsDTO;

    private Long ammount;

    public OrderItemDTO() {
    }
}
