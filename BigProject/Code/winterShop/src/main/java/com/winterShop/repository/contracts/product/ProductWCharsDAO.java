package com.winterShop.repository.contracts.product;

import com.winterShop.repository.model.product.ProductWChars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ProductWCharsDAO extends JpaRepository<ProductWChars, Long> {
}
