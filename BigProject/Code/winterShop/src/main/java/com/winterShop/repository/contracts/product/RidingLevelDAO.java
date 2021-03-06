package com.winterShop.repository.contracts.product;

import com.winterShop.repository.model.product.RidingLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RidingLevelDAO extends JpaRepository<RidingLevel, Long> {
}
