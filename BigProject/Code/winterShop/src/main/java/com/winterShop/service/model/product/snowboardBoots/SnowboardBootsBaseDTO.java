package com.winterShop.service.model.product.snowboardBoots;


import com.winterShop.service.model.product.ProductDTO;
import com.winterShop.service.model.product.RidingLevelDTO;
import com.winterShop.service.model.product.RidingStyleDTO;


import java.util.Set;


public class SnowboardBootsBaseDTO extends ProductDTO {

    private Long stiffness;

    private Set<RidingStyleDTO> ridingStyleDTOSet;

    private Set<RidingLevelDTO> ridingLevelDTOSet;

    public SnowboardBootsBaseDTO() {
    }

    public Long getStiffness() {
        return stiffness;
    }

    public void setStiffness(Long stiffness) {
        this.stiffness = stiffness;
    }

    public Set<RidingStyleDTO> getRidingStyleDTOSet() {
        return ridingStyleDTOSet;
    }

    public void setRidingStyleDTOSet(Set<RidingStyleDTO> ridingStyleDTOSet) {
        this.ridingStyleDTOSet = ridingStyleDTOSet;
    }

    public Set<RidingLevelDTO> getRidingLevelDTOSet() {
        return ridingLevelDTOSet;
    }

    public void setRidingLevelDTOSet(Set<RidingLevelDTO> ridingLevelDTOSet) {
        this.ridingLevelDTOSet = ridingLevelDTOSet;
    }
}
