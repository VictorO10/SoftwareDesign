package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;


public class ProductDTO implements Serializable {

    protected Long productId;

    protected Long price;

    protected String name;

    protected String description;

   // @JsonManagedReference
    protected BrandDTO brandDTO;

  //  @JsonManagedReference
    protected TargetGroupDTO targetGroupDTO;

  //  @JsonManagedReference
    protected CategoryDTO categoryDTO;

    protected Set<ProductWCharsDTO> productWCharsDTOSet;





    public ProductDTO() {
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

   // @JsonManagedReference
    public BrandDTO getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

   // @JsonManagedReference
    public TargetGroupDTO getTargetGroupDTO() {
        return targetGroupDTO;
    }

    public void setTargetGroupDTO(TargetGroupDTO targetGroupDTO) {
        this.targetGroupDTO = targetGroupDTO;
    }

   // @JsonManagedReference
    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public Set<ProductWCharsDTO> getProductWCharsDTOSet() {
        return productWCharsDTOSet;
    }

    public void setProductWCharsDTOSet(Set<ProductWCharsDTO> productWCharsDTOSet) {
        this.productWCharsDTOSet = productWCharsDTOSet;
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
        System.out.println("TO STRING FROM ProductDTO");
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            return "productDTO to jackson error\n";
        }
    }
}
