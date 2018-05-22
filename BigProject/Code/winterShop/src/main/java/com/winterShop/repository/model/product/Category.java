package com.winterShop.repository.model.product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long categoryId;

    private String category;


    @OneToMany(mappedBy = "category")
    private Set<Product> productSet;


    public Category() {
    }
}
