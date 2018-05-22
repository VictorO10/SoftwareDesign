package com.winterShop.repository.model.product;

import com.winterShop.repository.model.inventory.Inventory;
import com.winterShop.repository.model.order.OrderItem;
import com.winterShop.repository.model.product.snowboard.SnowboardCharacteristics;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsCharacteristics;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductWChars {

    @SequenceGenerator(
            name="productWChars_seq",
            sequenceName = "productWChars_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productWChars_seq")
    @Id
    private Long productWCharsId;


    @ManyToOne
    @JoinColumn(name="productId", nullable = false)
    private Product product;

    @OneToOne
    @JoinColumn(name="snowboardCharacteristics_id", nullable = true)
    private SnowboardCharacteristics snowboardCharacteristics;

    @OneToOne
    @JoinColumn(name="snowboardBootsCharacteristics_id", nullable = true)
    private SnowboardBootsCharacteristics snowboardBootsCharacteristics;


    @OneToMany(mappedBy = "productWChars")
    protected Set<Inventory> inventorySet;

    @OneToMany(mappedBy = "productWChars")
    protected Set<OrderItem> orderItemSet;

    public ProductWChars() {
    }
}
