package com.winterShop.service.contracts.user;

import com.winterShop.service.model.user.UserDTO;

public interface LoggedInService {

    String getLoggedInEmail();

    UserDTO getLoggedInUserDTO();

}
