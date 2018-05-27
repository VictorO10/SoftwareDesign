package com.winterShop.repository.model.product.snowboardBoots;


import com.winterShop.repository.model.product.Product;
import com.winterShop.repository.model.product.RidingLevel;
import com.winterShop.repository.model.product.RidingStyle;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Set;

@Entity
public class SnowboardBootsBase extends Product {

    @DecimalMin("1")
    @DecimalMax("10")
    private Long stiffness;

    @ManyToMany
    @JoinTable(
            name = "SnowboardBoots_RidingStyle",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "ridingStyle_id")}
    )
    private Set<RidingStyle> ridingStyleSet;

    @ManyToMany
    @JoinTable(
            name = "SnowboardBootsBase_RidingLevel",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "ridingLevel_id")}
    )
    private Set<RidingLevel> ridingLevelSet;

    public SnowboardBootsBase() {
    }
}
