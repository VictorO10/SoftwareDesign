package com.winterShop.service.model.order;

import javax.persistence.*;
import java.util.Set;


public class OrderDetailsDTO {


    private Long orderDetailsId;

    @OneToMany(mappedBy = "orderDetails")
    private Set<OrderItemDTO> orderItemDTOSet;

    private OrderStatusDTO orderStatusDTO;

    public OrderDetailsDTO() {
    }
}
