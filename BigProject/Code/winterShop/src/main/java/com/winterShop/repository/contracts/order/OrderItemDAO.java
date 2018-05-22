package com.winterShop.repository.contracts.order;

import com.winterShop.repository.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderItemDAO extends JpaRepository<OrderItem, Long> {
}
