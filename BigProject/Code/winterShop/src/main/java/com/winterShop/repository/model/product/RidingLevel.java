package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboard.SnowboardBase;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RidingLevel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long ridingLevelId;

    private String level;

    private String levelDescription;

    @ManyToMany(mappedBy = "ridingLevelSet")
    private Set<SnowboardBootsBase> snowboardBootsBaseSet;

    @ManyToMany(mappedBy = "ridingLevelSet")
    private Set<SnowboardBase> snowboardBaseSet;

    public RidingLevel() {
    }
}
