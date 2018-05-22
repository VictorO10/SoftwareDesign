package com.winterShop.service.model.user;

import java.util.Set;


public class UserDTO {

    private Long userid;

    private String email;

    private String password;

    private String token;

    private Set<UserRoleDTO> roles;

    public UserDTO() {
    }
}
