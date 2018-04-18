package com.example.controller;

import com.example.controller.exceptions.UserNotFoundException;
import com.example.model.service.models.UserDTO;
import com.example.model.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //exceptions
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUserNotFoundException() {
        return "User ID not found!";
    }

    @GetMapping("getUsers")
    public List<UserDTO> getAllUsers(){
        try {
            return userService.getAllUsers();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("getUserById")
    public UserDTO getUserById(@RequestParam Long iduser){
        try {
            return userService.getUserByID(iduser);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }
    }

    @PostMapping("saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        try {
            return userService.saveUser(userDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("registerStudent")
    public UserDTO registerStudent(@RequestParam String email, @RequestParam String fullName, @RequestParam String group, @RequestParam String hobby) {
        try {
            return userService.registerStudent(email, fullName, group, hobby);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("registerWithToken")
    public UserDTO registerWithToken(@RequestParam String token, @RequestParam String pass) {
        try {
            return userService.registerWithToken(token, pass);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("updateUser")
    public UserDTO updateUser(@RequestParam Long iduser, @RequestBody UserDTO userDTO){
        try {
            return userService.updateUser(iduser, userDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }
    }

    @PostMapping("login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @DeleteMapping("deleteUserById")
    public String deleteUserById(Long iduser) {
        try {
            userService.deleteUserById(iduser);
            return "User with id = " + iduser + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new UserNotFoundException();
        }
    }
}
