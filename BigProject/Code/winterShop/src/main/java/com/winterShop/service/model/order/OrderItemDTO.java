package com.winterShop.service.model.order;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winterShop.service.model.product.ProductWCharsDTO;


public class OrderItemDTO {

    private Long orderItemId;

    private ProductWCharsDTO productWCharsDTO;

    @JsonBackReference(value = "orderItemDTO-orderDetailsDTO")
    private OrderDetailsDTO orderDetailsDTO;

    private Long ammount;

    public OrderItemDTO() {
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public ProductWCharsDTO getProductWCharsDTO() {
        return productWCharsDTO;
    }

    public void setProductWCharsDTO(ProductWCharsDTO productWCharsDTO) {
        this.productWCharsDTO = productWCharsDTO;
    }

    public OrderDetailsDTO getOrderDetailsDTO() {
        return orderDetailsDTO;
    }

    public void setOrderDetailsDTO(OrderDetailsDTO orderDetailsDTO) {
        this.orderDetailsDTO = orderDetailsDTO;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }
}
