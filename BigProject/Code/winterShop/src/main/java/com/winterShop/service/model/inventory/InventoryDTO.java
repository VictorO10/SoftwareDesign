package com.winterShop.service.model.inventory;

import com.winterShop.service.model.product.ProductWCharsDTO;


public class InventoryDTO {

    protected Long inventoryId;

    private ProductWCharsDTO productWCharsDTO;

    private Long stock;

    public InventoryDTO() {
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public ProductWCharsDTO getProductWCharsDTO() {
        return productWCharsDTO;
    }

    public void setProductWCharsDTO(ProductWCharsDTO productWCharsDTO) {
        this.productWCharsDTO = productWCharsDTO;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
