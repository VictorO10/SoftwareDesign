package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @JsonBackReference("productWChars-orderItem")
    protected Set<OrderItemDTO> orderItemDTOSet;

    private String image;

    private Long stock;

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

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public void decrementStock(){
        this.stock --;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
//            return e.toString();
            return "productWCharsDTO to jackson error\n";
        }
    }
}
