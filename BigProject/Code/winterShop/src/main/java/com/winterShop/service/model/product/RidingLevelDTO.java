package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;

import java.util.Set;


public class RidingLevelDTO {

    private Long ridingLevelId;

    private String level;

    private String levelDescription;

    @JsonBackReference(value = "ridingLevelSnowboardBoots")
    private Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet;

    @JsonBackReference(value = "ridingLevelSnowboard")
    private Set<SnowboardBaseDTO> snowboardBaseDTOSet;

    public RidingLevelDTO() {
    }

    public Long getRidingLevelId() {
        return ridingLevelId;
    }

    public void setRidingLevelId(Long ridingLevelId) {
        this.ridingLevelId = ridingLevelId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public Set<SnowboardBootsBaseDTO> getSnowboardBootsBaseDTOSet() {
        return snowboardBootsBaseDTOSet;
    }

    public void setSnowboardBootsBaseDTOSet(Set<SnowboardBootsBaseDTO> snowboardBootsBaseDTOSet) {
        this.snowboardBootsBaseDTOSet = snowboardBootsBaseDTOSet;
    }

    public Set<SnowboardBaseDTO> getSnowboardBaseDTOSet() {
        return snowboardBaseDTOSet;
    }

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

            return "ridingLevelDTO to jackson error\n";
        }
    }

    @Override
    public boolean equals(Object obj) {
        RidingLevelDTO ridingLevelDTO = (RidingLevelDTO)obj;

        return ridingLevelDTO.getRidingLevelId().intValue() == this.getRidingLevelId().intValue();
    }

    @Override
    public int hashCode() {
        return ridingLevelId.intValue();
    }
}
