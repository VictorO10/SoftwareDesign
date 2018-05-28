package com.winterShop.repository.contracts.order;

import com.winterShop.repository.model.order.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long> {

    Set<OrderDetails> findAllByUser_email(String email);
}
