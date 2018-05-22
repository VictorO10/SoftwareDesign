package com.winterShop.service.model.product;

import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;

import java.util.Set;


public class RidingStyleDTO {

    private Long ridingStyleId;

    private String style;

    private String styleDescription;

    private Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet;

    private Set<SnowboardBaseDTO> snowboardBaseDTOSet;

    public RidingStyleDTO() {
    }
}
