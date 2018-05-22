package com.winterShop.repository.contracts.product.snowboard;

import com.winterShop.repository.model.product.snowboard.SnowboardCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SnowboardCharacteristicsDAO extends JpaRepository<SnowboardCharacteristics, Long> {
}
