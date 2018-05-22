package com.winterShop.service.model.product;

import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ShoeSizeDTO {


    int ShoeSizeId;

    private Long cm;
    private Long eu;

    private Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet;

    public ShoeSizeDTO() {
    }
}
