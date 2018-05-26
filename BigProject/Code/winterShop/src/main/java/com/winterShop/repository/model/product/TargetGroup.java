package com.winterShop.repository.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TargetGroup {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long targetGroupId;

    private String groupName;

    @OneToMany(mappedBy = "targetGroup")
    @JsonBackReference
    private Set<Product> products;


    public TargetGroup() {
    }

    public Long getTargetGroupId() {
        return targetGroupId;
    }

    public void setTargetGroupId(Long targetGroupId) {
        this.targetGroupId = targetGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
