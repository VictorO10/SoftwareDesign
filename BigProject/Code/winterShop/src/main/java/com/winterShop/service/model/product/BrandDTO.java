package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Set;


public class BrandDTO {

    private Long brandId;

    private String name;

    private String description;

    @JsonIgnore
    private Set<ProductDTO> productDTOS;

    public BrandDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
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
    
    @JsonIgnore
    public Set<ProductDTO> getProduct() {
        return productDTOS;
    }
    @JsonIgnore
    public void setProduct(Set<ProductDTO> productDTO) {
        this.productDTOS = productDTO;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();


//        return "\n\nbrandDTO to JSON \n\n";
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "brandDTO to jackson error\n";
        }
    }
}
