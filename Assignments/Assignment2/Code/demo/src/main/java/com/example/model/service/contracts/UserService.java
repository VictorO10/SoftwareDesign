package com.example.model.service.contracts;

import com.example.model.service.models.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserByID(Long iduser);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(Long iduser, UserDTO userDTO);

    void deleteUserById(Long iduser);

    UserDTO registerStudent(String email, String fullName, String group, String hobby);

    UserDTO registerWithToken(String token, String pass);

    String login(String user, String pass);
}
