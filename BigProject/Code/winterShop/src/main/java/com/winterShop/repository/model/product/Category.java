package com.winterShop.repository.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long categoryId;

    private String category;


    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Product> productSet;


    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
