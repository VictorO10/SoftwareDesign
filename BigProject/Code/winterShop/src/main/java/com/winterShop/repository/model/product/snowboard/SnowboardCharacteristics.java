package com.winterShop.repository.model.product.snowboard;

import javax.persistence.*;

@Entity
public class SnowboardCharacteristics {

    @SequenceGenerator(
            name = "snowboardChars_seq",
            sequenceName = "snowboardChars_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snowboardChars_seq")
    @Id
    private Long snowboardCharacteristicsId;

    private Long length;

    public SnowboardCharacteristics() {
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
