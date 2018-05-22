package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboard.SnowboardBase;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RidingStyle {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long ridingStyleId;

    private String style;

    private String styleDescription;

    @ManyToMany(mappedBy = "ridingStyleSet")
    private Set<SnowboardBootsBase> snowboardBootsBaseSet;

    @ManyToMany(mappedBy = "ridingStyleSet")
    private Set<SnowboardBase> snowboardBaseSet;

    public RidingStyle() {
    }
}
