package com.winterShop.service.model.product.snowboardBoots;


import com.winterShop.service.model.product.ProductDTO;
import com.winterShop.service.model.product.RidingLevelDTO;
import com.winterShop.service.model.product.RidingStyleDTO;


import java.util.Set;


public class SnowboardBootsBaseDTO extends ProductDTO {

    private Long stiffness;

    private Set<RidingStyleDTO> ridingStyleDTOSet;

    private Set<RidingLevelDTO> ridingLevelDTOSet;

    Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet;

    public SnowboardBootsBaseDTO() {
    }
}
