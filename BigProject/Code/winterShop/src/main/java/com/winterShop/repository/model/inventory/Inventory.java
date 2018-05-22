package com.winterShop.repository.model.inventory;

import com.winterShop.repository.model.product.ProductWChars;

import javax.persistence.*;

@Entity
public class Inventory {

    @SequenceGenerator(
            name="inventory_seq",
            sequenceName = "inventory_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="inventory_seq")
    @Id
    protected Long inventoryId;


    @ManyToOne
    @JoinColumn(name="productWCharsId", nullable=false)
    private ProductWChars productWChars;

    private Long stock;

    public Inventory() {
    }
}
