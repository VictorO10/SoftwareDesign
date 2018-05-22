package com.winterShop.repository.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winterShop.repository.model.inventory.Inventory;
import com.winterShop.repository.model.order.OrderItem;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @SequenceGenerator(
            name="product_seq",
            sequenceName = "product_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
    @Id
    protected Long productId;

    protected Long price;

    protected String name;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable = true)
    @JsonBackReference
    protected Brand brand;

    @ManyToOne
    @JoinColumn(name="targetGroup_id", nullable = true)
    protected TargetGroup targetGroup;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = true)
    protected Category category;

    @OneToMany(mappedBy = "product")
    protected Set<ProductWChars> productWCharsSet;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TargetGroup getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(TargetGroup targetGroup) {
        this.targetGroup = targetGroup;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductWChars> getProductWCharsSet() {
        return productWCharsSet;
    }

    public void setProductWCharsSet(Set<ProductWChars> productWCharsSet) {
        this.productWCharsSet = productWCharsSet;
    }
}
