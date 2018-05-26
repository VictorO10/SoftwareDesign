package com.winterShop.service.model.product;

import com.winterShop.service.model.inventory.InventoryDTO;
import com.winterShop.service.model.order.OrderItemDTO;
import com.winterShop.service.model.product.snowboard.SnowboardCharacteristicsDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ProductWCharsDTO {

    private Long productWCharsId;

    private ProductDTO productDTO;

    private SnowboardCharacteristicsDTO snowboardCharacteristicsDTO;

    private SnowboardBootsCharacteristicsDTO snowboardBootsCharacteristicsDTO;

    protected Set<InventoryDTO> inventoryDTOSet;

    protected Set<OrderItemDTO> orderItemDTOSet;

    private String image;

    public ProductWCharsDTO() {
    }

    public Long getProductWCharsId() {
        return productWCharsId;
    }

    public void setProductWCharsId(Long productWCharsId) {
        this.productWCharsId = productWCharsId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public SnowboardCharacteristicsDTO getSnowboardCharacteristicsDTO() {
        return snowboardCharacteristicsDTO;
    }

    public void setSnowboardCharacteristicsDTO(SnowboardCharacteristicsDTO snowboardCharacteristicsDTO) {
        this.snowboardCharacteristicsDTO = snowboardCharacteristicsDTO;
    }

    public SnowboardBootsCharacteristicsDTO getSnowboardBootsCharacteristicsDTO() {
        return snowboardBootsCharacteristicsDTO;
    }

    public void setSnowboardBootsCharacteristicsDTO(SnowboardBootsCharacteristicsDTO snowboardBootsCharacteristicsDTO) {
        this.snowboardBootsCharacteristicsDTO = snowboardBootsCharacteristicsDTO;
    }

    public Set<InventoryDTO> getInventoryDTOSet() {
        return inventoryDTOSet;
    }

    public void setInventoryDTOSet(Set<InventoryDTO> inventoryDTOSet) {
        this.inventoryDTOSet = inventoryDTOSet;
    }

    public Set<OrderItemDTO> getOrderItemDTOSet() {
        return orderItemDTOSet;
    }

    public void setOrderItemDTOSet(Set<OrderItemDTO> orderItemDTOSet) {
        this.orderItemDTOSet = orderItemDTOSet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
