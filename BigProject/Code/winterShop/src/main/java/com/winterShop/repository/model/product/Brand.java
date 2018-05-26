package com.winterShop.repository.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Brand {

    @SequenceGenerator(
            name="brand_seq",
            sequenceName = "brand_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @Id
    private Long brandId;

    private String name;

    @Column(length = 50000)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy="brand")
    private Set<Product> products;

    public Brand() {
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProduct() {
        return products;
    }

    public void setProduct(Set<Product> product) {
        this.products = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();


        return "\n\n BRAND MODEL TO JSON \n\n";
//        try {
//            return objectMapper.writeValueAsString(this);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "\n\nBRAND MODEL to jackson error\n\n";
//        }
    }
}
