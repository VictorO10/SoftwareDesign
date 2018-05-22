package com.winterShop.repository.model.product.snowboard;

import com.winterShop.repository.model.product.Product;
import com.winterShop.repository.model.product.RidingLevel;
import com.winterShop.repository.model.product.RidingStyle;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Set;

@Entity
public class SnowboardBase extends Product {

    @DecimalMin("1")
    @DecimalMax("10")
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
}
