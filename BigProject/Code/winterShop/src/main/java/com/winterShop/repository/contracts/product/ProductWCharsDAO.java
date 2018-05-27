package com.winterShop.repository.contracts.product;

import com.winterShop.repository.model.product.ProductWChars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface ProductWCharsDAO extends JpaRepository<ProductWChars, Long> {

    List<ProductWChars> findByProduct_productId(Long productId);
}
