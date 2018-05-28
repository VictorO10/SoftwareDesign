package com.winterShop.service.impl.user;

import com.winterShop.service.contracts.user.LoggedInService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedInServiceImpl implements LoggedInService {

    @Override
    public String getLoggedInEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalEmail = authentication.getName();

        return currentPrincipalEmail;
    }

}
