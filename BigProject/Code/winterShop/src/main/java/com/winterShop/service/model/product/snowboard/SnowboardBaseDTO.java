package com.winterShop.service.model.product.snowboard;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winterShop.service.model.product.ProductDTO;
import com.winterShop.service.model.product.RidingLevelDTO;
import com.winterShop.service.model.product.RidingStyleDTO;

import java.util.Set;


public class SnowboardBaseDTO extends ProductDTO {

    private Long stiffness;

    private Set<RidingStyleDTO> ridingStyleDTOSet;

    private Set<RidingLevelDTO> ridingLevelDTOSet;

    public SnowboardBaseDTO() {
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

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
 //       System.out.println("TO STRING FROM SnowboardBase");
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "snowboardBaseDTO to jackson error\n";
        }
    }
}
