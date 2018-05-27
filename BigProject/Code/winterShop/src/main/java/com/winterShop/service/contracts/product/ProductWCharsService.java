package com.winterShop.service.contracts.product;

import com.winterShop.repository.contracts.product.ProductWCharsDAO;
import com.winterShop.service.contracts.AbstractService;
import com.winterShop.service.model.product.ProductWCharsDTO;

import java.util.List;

public interface ProductWCharsService extends AbstractService<ProductWCharsDTO, Long> {
    ProductWCharsDTO updateImgAndStock(Long id, ProductWCharsDTO entity);

    List<ProductWCharsDTO> findByProduct_productId(Long productId);
}
