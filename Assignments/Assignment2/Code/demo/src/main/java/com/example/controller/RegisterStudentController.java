package com.example.controller;

import com.example.controller.exceptions.UserWithEmailExistsException;
import com.example.model.service.contracts.UserService;
import com.example.model.service.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RegisterStudent")
public class RegisterStudentController {

    private final UserService userService;

    @Autowired
    public RegisterStudentController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("")
    public UserDTO registerWithToken(@RequestParam String token, @RequestParam String pass) {
        try {
            return userService.registerWithToken(token, pass);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
