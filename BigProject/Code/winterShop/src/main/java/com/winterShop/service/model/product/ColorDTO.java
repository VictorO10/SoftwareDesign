package com.winterShop.service.model.product;

import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ColorDTO {

    private Long colorId;

    private String name;

    private Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet;

    public ColorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
