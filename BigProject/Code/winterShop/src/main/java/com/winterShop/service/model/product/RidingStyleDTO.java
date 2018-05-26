package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winterShop.repository.model.product.RidingStyle;
import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;

import java.util.Set;


public class RidingStyleDTO {

    private Long ridingStyleId;

    private String style;

    private String styleDescription;

    @JsonBackReference(value="ridingStyleSnowboardBoots")
    private Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet;

    @JsonBackReference(value="ridingStyleSnowboard")
    private Set<SnowboardBaseDTO> snowboardBaseDTOSet;

    public RidingStyleDTO() {
    }

    public Long getRidingStyleId() {
        return ridingStyleId;
    }

    public void setRidingStyleId(Long ridingStyleId) {
        this.ridingStyleId = ridingStyleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

//    @JsonBackReference
    public Set<SnowboardBootsBaseDTO> getSnowboardBootsBaseDTOSet() {
        return snowboardBootsBaseDTOSet;
    }

//    @JsonBackReference
    public void setSnowboardBootsBaseDTOSet(Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet) {
        this.snowboardBootsBaseDTOSet = snowboardBootsBaseDTOSet;
    }

//    @JsonBackReference
    public Set<SnowboardBaseDTO> getSnowboardBaseDTOSet() {
        return snowboardBaseDTOSet;
    }

//    @JsonBackReference
    public void setSnowboardBaseDTOSet(Set<SnowboardBaseDTO> snowboardBaseDTOSet) {
        this.snowboardBaseDTOSet = snowboardBaseDTOSet;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
//            e.printStackTrace();

            return "ridingStyleDTO to jackson error\n";
        }
    }

    @Override
    public boolean equals(Object obj) {
        RidingStyleDTO ridingStyleDTO = (RidingStyleDTO) obj;

        return ridingStyleDTO.getRidingStyleId().intValue() == ridingStyleId.intValue();
    }

    @Override
    public int hashCode() {
        return ridingStyleId.intValue();
    }
}
