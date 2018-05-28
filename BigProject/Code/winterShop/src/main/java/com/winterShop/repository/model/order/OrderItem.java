package com.winterShop.repository.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winterShop.repository.model.product.ProductWChars;


import javax.persistence.*;

@Entity
public class OrderItem {

    @SequenceGenerator(
            name="orderItem_seq",
            sequenceName = "orderItem_sequence",
            allocationSize = 5
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_seq")
    @Id
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name="productWCharsId", nullable=false)
    private ProductWChars productWChars;

    @ManyToOne
    @JoinColumn(name="orderDetailsId", nullable = false)
    @JsonBackReference(value = "orderItem-orderDetails")
    private OrderDetails orderDetails;

    private Long ammount;

    public OrderItem() {
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public ProductWChars getProductWChars() {
        return productWChars;
    }

    public void setProductWChars(ProductWChars productWChars) {
        this.productWChars = productWChars;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }
}
