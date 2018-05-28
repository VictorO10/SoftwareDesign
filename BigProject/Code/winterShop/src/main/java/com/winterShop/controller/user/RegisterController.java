package com.winterShop.controller.user;

import com.winterShop.service.contracts.user.UserService;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getPage(Model model){
        model.addAttribute("info", "Register here");

        return "user/register";
    }

    @PostMapping
    public String register(String email, String password, Model model) {

        System.out.println("email: " + email);

        EmailValidator emailValidator = new EmailValidator();

        if(! emailValidator.isValid(email, null)) { //email not valid
            model.addAttribute("info", "Invalid E-mail");
        } else {
            userService.register(email, password);
            model.addAttribute("info", "Registration Successful. An E-mail has been sent to " + email);
        }

        return "user/register";
    }
}
