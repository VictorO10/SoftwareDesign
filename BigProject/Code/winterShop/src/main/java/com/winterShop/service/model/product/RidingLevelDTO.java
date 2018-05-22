package com.winterShop.service.model.product;

import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;

import java.util.Set;


public class RidingLevelDTO {

    private Long ridingLevelId;

    private String level;

    private String levelDescription;

    private Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet;

    private Set<SnowboardBaseDTO> snowboardBaseDTOSet;

    public RidingLevelDTO() {
    }
}
