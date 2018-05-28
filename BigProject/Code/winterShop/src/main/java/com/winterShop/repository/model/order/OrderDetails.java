package com.winterShop.repository.model.order;

import com.winterShop.repository.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderDetails {

    @SequenceGenerator(
            name = "orderDetails_seq",
            sequenceName = "orderDetails_sequence",
            allocationSize = 5
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetails_seq")
    @Id
    private Long orderDetailsId;

    @OneToMany(mappedBy = "orderDetails", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItemSet;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderDetails() {
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
