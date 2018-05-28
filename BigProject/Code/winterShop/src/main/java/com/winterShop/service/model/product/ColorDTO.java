package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ColorDTO {

    private Long colorId;

    private String name;

    @JsonBackReference("colorDTO-SnowboardBootsCharacteristicsDTO")
    private Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet;

    public ColorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

}
