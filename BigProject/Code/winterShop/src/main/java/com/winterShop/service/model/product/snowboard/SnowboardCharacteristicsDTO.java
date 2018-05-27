package com.winterShop.service.model.product.snowboard;


import com.fasterxml.jackson.annotation.JsonBackReference;

public class SnowboardCharacteristicsDTO {

    private Long snowboardCharacteristicsId;

    private Long length;

    public SnowboardCharacteristicsDTO() {
    }

    public Long getSnowboardCharacteristicsId() {
        return snowboardCharacteristicsId;
    }

    public void setSnowboardCharacteristicsId(Long snowboardCharacteristicsId) {
        this.snowboardCharacteristicsId = snowboardCharacteristicsId;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

}
