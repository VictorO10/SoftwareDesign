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

    private String image;

    public ProductWChars() {
    }

    public Long getProductWCharsId() {
        return productWCharsId;
    }

    public void setProductWCharsId(Long productWCharsId) {
        this.productWCharsId = productWCharsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SnowboardCharacteristics getSnowboardCharacteristics() {
        return snowboardCharacteristics;
    }

    public void setSnowboardCharacteristics(SnowboardCharacteristics snowboardCharacteristics) {
        this.snowboardCharacteristics = snowboardCharacteristics;
    }

    public SnowboardBootsCharacteristics getSnowboardBootsCharacteristics() {
        return snowboardBootsCharacteristics;
    }

    public void setSnowboardBootsCharacteristics(SnowboardBootsCharacteristics snowboardBootsCharacteristics) {
        this.snowboardBootsCharacteristics = snowboardBootsCharacteristics;
    }

    public Set<Inventory> getInventorySet() {
        return inventorySet;
    }

    public void setInventorySet(Set<Inventory> inventorySet) {
        this.inventorySet = inventorySet;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
