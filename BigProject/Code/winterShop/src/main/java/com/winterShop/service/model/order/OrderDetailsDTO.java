package com.winterShop.service.model.order;

import com.winterShop.service.model.user.UserDTO;

import javax.persistence.*;
import java.util.Set;


public class OrderDetailsDTO {


    private Long orderDetailsId;

    private Set<OrderItemDTO> orderItemDTOSet;

    private OrderStatusDTO orderStatusDTO;

    private UserDTO userDTO;

    public OrderDetailsDTO() {
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Set<OrderItemDTO> getOrderItemDTOSet() {
        return orderItemDTOSet;
    }

    public void setOrderItemDTOSet(Set<OrderItemDTO> orderItemDTOSet) {
        this.orderItemDTOSet = orderItemDTOSet;
    }

    public OrderStatusDTO getOrderStatusDTO() {
        return orderStatusDTO;
    }

    public void setOrderStatusDTO(OrderStatusDTO orderStatusDTO) {
        this.orderStatusDTO = orderStatusDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
