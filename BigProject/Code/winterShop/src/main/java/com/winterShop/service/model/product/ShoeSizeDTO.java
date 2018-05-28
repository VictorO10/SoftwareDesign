package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;

import java.util.Set;


public class ShoeSizeDTO {


    int ShoeSizeId;

    private Long cm;
    private Long eu;

    @JsonBackReference("shoeSizeDTO-SnowboardBootsCharacteristicsDTO")
    private Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet;

    public ShoeSizeDTO() {
    }

    public int getShoeSizeId() {
        return ShoeSizeId;
    }

    public void setShoeSizeId(int shoeSizeId) {
        ShoeSizeId = shoeSizeId;
    }

    public Long getCm() {
        return cm;
    }

    public void setCm(Long cm) {
        this.cm = cm;
    }

    public Long getEu() {
        return eu;
    }

    public void setEu(Long eu) {
        this.eu = eu;
    }

    public Set<SnowboardBootsCharacteristicsDTO> getSnowboardBootsCharacteristicsDTOSet() {
        return snowboardBootsCharacteristicsDTOSet;
    }

    public void setSnowboardBootsCharacteristicsDTOSet(Set<SnowboardBootsCharacteristicsDTO> snowboardBootsCharacteristicsDTOSet) {
        this.snowboardBootsCharacteristicsDTOSet = snowboardBootsCharacteristicsDTOSet;
    }
}
