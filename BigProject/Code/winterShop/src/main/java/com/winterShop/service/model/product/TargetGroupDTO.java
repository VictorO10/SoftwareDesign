package com.winterShop.service.model.product;

import java.util.Set;


public class TargetGroupDTO {

    private Long targetGroupId;

    private String groupName;

    private Set<ProductDTO> productDTOS;


    public TargetGroupDTO() {
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

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(Set<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }
}
