package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsCharacteristics;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Color {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long colorId;

    private String name;


    @OneToMany(mappedBy = "color")
    private Set<SnowboardBootsCharacteristics> snowboardBootsCharacteristicsSet;


    public Color() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
