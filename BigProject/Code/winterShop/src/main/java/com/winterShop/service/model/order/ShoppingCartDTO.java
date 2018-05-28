package com.winterShop.service.model.order;

import com.winterShop.repository.model.user.User;
import com.winterShop.service.model.user.UserDTO;

import javax.persistence.*;
import java.util.Set;

public class ShoppingCartDTO {

    private Long shoppingCartId;

    private Set<ShoppingCartLineDTO> shoppingCartLineDTOSet;

    private UserDTO userDTO;

    public ShoppingCartDTO() {
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Set<ShoppingCartLineDTO> getShoppingCartLineDTOSet() {
        return shoppingCartLineDTOSet;
    }

    public void setShoppingCartLineDTOSet(Set<ShoppingCartLineDTO> shoppingCartLineDTOSet) {
        this.shoppingCartLineDTOSet = shoppingCartLineDTOSet;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
