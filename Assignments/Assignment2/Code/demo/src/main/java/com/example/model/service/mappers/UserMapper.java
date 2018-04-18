package com.example.model.service.mappers;

import com.example.model.dao.models.UserModel;
import com.example.model.service.models.UserDTO;

public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        return new UserModel(
                userDTO.getIduser(),
                userDTO.getFullName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getGroupName(),
                userDTO.getHobby(),
                userDTO.isTeacher(),
                userDTO.getToken()
        );
    }

    public UserDTO map(UserModel userModel) {
        return new UserDTO(
                userModel.getIduser(),
                userModel.getFullName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getGroupName(),
                userModel.getHobby(),
                userModel.isTeacher(),
                userModel.getToken()
        );
    }
}
