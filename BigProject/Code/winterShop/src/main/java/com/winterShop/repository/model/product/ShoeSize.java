package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsCharacteristics;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoeSize {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int ShoeSizeId;

    private Long cm;
    private Long eu;

    @OneToMany(mappedBy = "shoeSize")
    private Set<SnowboardBootsCharacteristics> snowboardBootsCharacteristicsSet;

    public ShoeSize() {
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

    public Set<SnowboardBootsCharacteristics> getSnowboardBootsCharacteristicsSet() {
        return snowboardBootsCharacteristicsSet;
    }

    public void setSnowboardBootsCharacteristicsSet(Set<SnowboardBootsCharacteristics> snowboardBootsCharacteristicsSet) {
        this.snowboardBootsCharacteristicsSet = snowboardBootsCharacteristicsSet;
    }
}
