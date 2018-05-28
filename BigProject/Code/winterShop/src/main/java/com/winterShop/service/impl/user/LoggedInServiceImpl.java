package com.winterShop.service.impl.user;

import com.winterShop.service.contracts.user.LoggedInService;
import com.winterShop.service.contracts.user.UserService;
import com.winterShop.service.model.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedInServiceImpl implements LoggedInService {

    @Autowired
    UserService userService;

    @Override
    public String getLoggedInEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalEmail = authentication.getName();

        return currentPrincipalEmail;
    }

    @Override
    public UserDTO getLoggedInUserDTO() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalEmail = authentication.getName();

        return userService.getByEmail(currentPrincipalEmail);
    }

}
