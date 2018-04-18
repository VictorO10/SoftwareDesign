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
@RequestMapping("RegisterTeacher")
public class RegisterTeacherController {

    private final UserService userService;

    @Autowired
    public RegisterTeacherController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public UserDTO registerStudent(@RequestParam String email, @RequestParam String fullName, @RequestParam String group, @RequestParam String hobby) {
        try {

            return userService.registerStudent(email, fullName, group, hobby);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UserWithEmailExistsException();
        }
    }
}
