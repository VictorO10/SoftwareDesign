package com.winterShop.service.model.product.snowboardBoots;

import com.winterShop.service.model.product.ColorDTO;
import com.winterShop.service.model.product.ShoeSizeDTO;


public class SnowboardBootsCharacteristicsDTO {

    private Long snowboardBootsCharacteristicsId;

    private ShoeSizeDTO shoeSizeDTO;

    private ColorDTO colorDTO;

    public SnowboardBootsCharacteristicsDTO() {
    }

    public Long getSnowboardBootsCharacteristicsId() {
        return snowboardBootsCharacteristicsId;
    }

    public void setSnowboardBootsCharacteristicsId(Long snowboardBootsCharacteristicsId) {
        this.snowboardBootsCharacteristicsId = snowboardBootsCharacteristicsId;
    }

    public ShoeSizeDTO getShoeSizeDTO() {
        return shoeSizeDTO;
    }

    public void setShoeSizeDTO(ShoeSizeDTO shoeSizeDTO) {
        this.shoeSizeDTO = shoeSizeDTO;
    }

    public ColorDTO getColorDTO() {
        return colorDTO;
    }

    public void setColorDTO(ColorDTO colorDTO) {
        this.colorDTO = colorDTO;
    }
}
