package com.winterShop.service.model.product.snowboard;

import com.winterShop.service.model.product.ProductDTO;
import com.winterShop.service.model.product.RidingLevelDTO;
import com.winterShop.service.model.product.RidingStyleDTO;

import java.util.Set;


public class SnowboardBaseDTO extends ProductDTO {

    private Long stiffness;


    private Set<RidingStyleDTO> ridingStyleDTOSet;

    private Set<RidingLevelDTO> ridingLevelDTOSet;

    private Set<SnowboardCharacteristicsDTO> snowboardCharacteristicsDTOSet;

    public SnowboardBaseDTO() {
    }
}
