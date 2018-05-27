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

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public ProductWChars getProductWChars() {
        return productWChars;
    }

    public void setProductWChars(ProductWChars productWChars) {
        this.productWChars = productWChars;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
