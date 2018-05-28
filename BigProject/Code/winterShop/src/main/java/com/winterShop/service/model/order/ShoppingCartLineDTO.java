package com.winterShop.service.model.order;

import com.winterShop.service.model.product.ProductWCharsDTO;

public class ShoppingCartLineDTO {

    private Long shoppingCartLineId;

    private ProductWCharsDTO productWCharsDTO;

    private ShoppingCartDTO shoppingCartDTO;

    private Long ammount;

    public ShoppingCartLineDTO() {
    }

    public Long getShoppingCartLineId() {
        return shoppingCartLineId;
    }

    public void setShoppingCartLineId(Long shoppingCartLineId) {
        this.shoppingCartLineId = shoppingCartLineId;
    }

    public ProductWCharsDTO getProductWCharsDTO() {
        return productWCharsDTO;
    }

    public void setProductWCharsDTO(ProductWCharsDTO productWCharsDTO) {
        this.productWCharsDTO = productWCharsDTO;
    }

    public ShoppingCartDTO getShoppingCartDTO() {
        return shoppingCartDTO;
    }

    public void setShoppingCartDTO(ShoppingCartDTO shoppingCartDTO) {
        this.shoppingCartDTO = shoppingCartDTO;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }
}
