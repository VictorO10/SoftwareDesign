package com.winterShop.service.contracts.user;

import com.winterShop.service.contracts.AbstractService;
import com.winterShop.service.model.user.UserDTO;

public interface UserService extends AbstractService<UserDTO, Long> {

    UserDTO getByEmail(String email);

    UserDTO register(String email, String password);
}
