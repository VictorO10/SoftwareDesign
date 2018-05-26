package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Set;


public class CategoryDTO implements Serializable {


    private Long categoryId;

    private String category;

    @JsonBackReference
    private Set<ProductDTO> productDTOSet;

    public CategoryDTO() {
    }

    public CategoryDTO(String JSONData) {

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

    @JsonBackReference
    public Set<ProductDTO> getProductDTOSet() {
        return productDTOSet;
    }

    @JsonBackReference
    public void setProductDTOSet(Set<ProductDTO> productDTOSet) {
        this.productDTOSet = productDTOSet;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "categoryDTO to jackson error\n";
        }
    }
}
