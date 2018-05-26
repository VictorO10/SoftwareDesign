package com.winterShop.repository.model.product.snowboard;

import com.winterShop.repository.model.product.Product;
import com.winterShop.repository.model.product.RidingLevel;
import com.winterShop.repository.model.product.RidingStyle;
import groovy.transform.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Set;

@Entity
public class SnowboardBase extends Product {

//    @DecimalMin("1")
//    @DecimalMax("10")
    private Long stiffness;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Snowboard_RidingStyle",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "ridingStyle_id")}
    )
    private Set<RidingStyle> ridingStyleSet;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Snowboard_RidingLevel",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "ridingLevel_id")}
    )
    private Set<RidingLevel> ridingLevelSet;

    @OneToMany(mappedBy = "snowboardBase")
    private Set<SnowboardCharacteristics> snowboardCharacteristicsSet;

    public SnowboardBase() {
    }

    public Long getStiffness() {
        return stiffness;
    }

    public void setStiffness(Long stiffness) {
        this.stiffness = stiffness;
    }

    public Set<RidingStyle> getRidingStyleSet() {
        return ridingStyleSet;
    }

    public void setRidingStyleSet(Set<RidingStyle> ridingStyleSet) {
        this.ridingStyleSet = ridingStyleSet;
    }

    public Set<RidingLevel> getRidingLevelSet() {
        return ridingLevelSet;
    }

    public void setRidingLevelSet(Set<RidingLevel> ridingLevelSet) {
        this.ridingLevelSet = ridingLevelSet;
    }

    public Set<SnowboardCharacteristics> getSnowboardCharacteristicsSet() {
        return snowboardCharacteristicsSet;
    }

    public void setSnowboardCharacteristicsSet(Set<SnowboardCharacteristics> snowboardCharacteristicsSet) {
        this.snowboardCharacteristicsSet = snowboardCharacteristicsSet;
    }


    @Override
    public String toString() {
        return ("TO STRING FROM SnowboardBase normal");
    }
}
