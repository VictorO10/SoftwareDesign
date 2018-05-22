package com.winterShop.repository.model.order;

import com.winterShop.repository.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderDetails {

    @SequenceGenerator(
            name = "orderDetails_seq",
            sequenceName = "orderDetails_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetails_seq")
    @Id
    private Long orderDetailsId;

    @OneToMany(mappedBy = "orderDetails")
    private Set<OrderItem> orderItemSet;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderDetails() {
    }
}
