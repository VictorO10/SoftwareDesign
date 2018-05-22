package com.winterShop.service.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;


public class ProductDTO {

    protected Long productId;

    protected Long price;

    protected String name;

    @JsonBackReference
    protected BrandDTO brandDTO;

    protected TargetGroupDTO targetGroupDTO;

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

    public BrandDTO getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

    public TargetGroupDTO getTargetGroupDTO() {
        return targetGroupDTO;
    }

    public void setTargetGroupDTO(TargetGroupDTO targetGroupDTO) {
        this.targetGroupDTO = targetGroupDTO;
    }

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
}
