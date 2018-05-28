package com.winterShop.service.model.user;

import java.util.Set;


public class UserDTO {

    private Long userId;

    private String email;

    private String password;

    private String token;

    private String address;

    private Set<UserRoleDTO> roles;

    public UserDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleDTO> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "{\n" +
                        "\"userId\": " + getUserId() + ",\n" +
                        "\"email\": " + getEmail() + ",\n" +
                        "\"password\": " + getPassword() + ",\n" +
                        "\"address\": " + getAddress() + "\n" +
                        "}";
    }
}
