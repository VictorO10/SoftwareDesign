package com.winterShop.repository.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Column(length = 50000)
    protected String description;

    protected String name;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable = true)
 //   @JsonManagedReference
    protected Brand brand;

    @ManyToOne
    @JoinColumn(name="targetGroup_id", nullable = true)
    protected TargetGroup targetGroup;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = true)
//    @JsonManagedReference
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

//        System.out.println("TO STRING FROM Product normal");

        return "\n\nbrandDTO to JSON\n\n";

//        try {
//            return objectMapper.writeValueAsString(this);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "brandDTO to jackson error\n";
//        }
    }
}
