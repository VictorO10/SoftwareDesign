package com.winterShop.repository.model.product.snowboardBoots;

import com.winterShop.repository.model.product.Color;
import com.winterShop.repository.model.product.ShoeSize;

import javax.persistence.*;

@Entity
public class SnowboardBootsCharacteristics {

    @SequenceGenerator(
            name = "snowboardBootsChars_seq",
            sequenceName = "snowboardBootsChars_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snowboardBootsChars_seq")
    @Id
    private Long snowboardBootsCharacteristicsId;

    @ManyToOne
    @JoinColumn(name="shoeSize_id", nullable = false)
    private ShoeSize shoeSize;

    @ManyToOne
    @JoinColumn(name="color_id", nullable = true)
    private Color color;

    public SnowboardBootsCharacteristics() {
    }

    public Long getSnowboardBootsCharacteristicsId() {
        return snowboardBootsCharacteristicsId;
    }

    public void setSnowboardBootsCharacteristicsId(Long snowboardBootsCharacteristicsId) {
        this.snowboardBootsCharacteristicsId = snowboardBootsCharacteristicsId;
    }

    public ShoeSize getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(ShoeSize shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
