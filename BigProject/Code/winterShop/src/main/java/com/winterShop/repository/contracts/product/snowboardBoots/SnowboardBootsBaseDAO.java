package com.winterShop.repository.contracts.product.snowboardBoots;

import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SnowboardBootsBaseDAO extends JpaRepository<SnowboardBootsBase, Long> {
}
