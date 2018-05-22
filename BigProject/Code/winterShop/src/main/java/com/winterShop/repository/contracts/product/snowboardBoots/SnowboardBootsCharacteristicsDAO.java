package com.winterShop.repository.contracts.product.snowboardBoots;

import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SnowboardBootsCharacteristicsDAO extends JpaRepository<SnowboardBootsCharacteristics, Long> {
}
