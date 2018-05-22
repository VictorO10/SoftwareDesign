package com.winterShop.repository.model.order;

import com.winterShop.repository.model.product.ProductWChars;


import javax.persistence.*;

@Entity
public class OrderItem {

    @SequenceGenerator(
            name="orderItem_seq",
            sequenceName = "orderItem_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_seq")
    @Id
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name="productWCharsId", nullable=false)
    private ProductWChars productWChars;

    @ManyToOne
    @JoinColumn(name="orderDetailsId", nullable = false)
    private OrderDetails orderDetails;

    private Long ammount;

    public OrderItem() {
    }
}
