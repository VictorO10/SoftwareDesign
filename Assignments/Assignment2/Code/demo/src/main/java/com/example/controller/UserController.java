package com.example.controller;

import com.example.controller.exceptions.UserNotFoundException;
import com.example.controller.exceptions.UserWithEmailExistsException;
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

    @ExceptionHandler(UserWithEmailExistsException.class)
    @ResponseStatus(HttpStatus.OK)
    public String handleUserWithEmailExistsException() {
        return "There already is a User with this email!";
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        try {
            return userService.getAllUsers();
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("{id}")
    public UserDTO getUserById(@PathVariable("id") Long iduser){
        try {
            return userService.getUserByID(iduser);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }
    }

    @PostMapping("")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        try {
            return userService.saveUser(userDTO);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("")
    public UserDTO updateUser(@RequestParam Long iduser, @RequestBody UserDTO userDTO){
        try {
            return userService.updateUser(iduser, userDTO);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        }
    }



    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable("id") Long iduser) {
        try {
            userService.deleteUserById(iduser);
            return "User with id = " + iduser + " successfully deleted!";
        } catch(Exception e) {
            e.getMessage();
            throw new UserNotFoundException();
        }
    }
}
