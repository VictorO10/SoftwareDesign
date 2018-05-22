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
}
