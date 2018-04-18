package com.example.model.service.impl;

import com.example.model.dao.UserDAO;
import com.example.model.dao.models.UserModel;
import com.example.model.service.contracts.EmailService;
import com.example.model.service.models.UserDTO;
import com.example.model.service.contracts.UserService;
import com.example.model.service.mappers.UserMapper;
import com.example.model.service.utility.PasswordEncryptor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserMapper userMapper;
    private final EmailService emailService;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, EmailService emailService) {
        this.userDAO = userDAO;
        this.emailService = emailService;
        userMapper = new UserMapper();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserModel> users = userDAO.findAll();

        //lambda
        return
                users.stream().map(userModel -> userMapper.map(userModel)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByID(Long iduser) {
        return userMapper.map(userDAO.findById(iduser).get());
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserModel userToBeSaved = userMapper.map(userDTO);

        userDAO.save(userToBeSaved);

        return userDTO;
    }

    @Override
    public UserDTO updateUser(Long iduser, UserDTO userDTO) {
        UserModel userToBeUpdated = userDAO.findById(iduser).get();

        if(userToBeUpdated != null) {
            userDTO.setIduser(iduser);
            userDAO.save(userMapper.map(userDTO));

            return userDTO;
        } else {
            return null;
        }

    }

    @Override
    public void deleteUserById(Long iduser) {
        userDAO.deleteById(iduser);
    }

    @Override
    public UserDTO registerStudent(String email, String fullName, String group, String hobby) {
        String generatedToken = RandomStringUtils.randomAlphanumeric(128);

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setFullName(fullName);
        userDTO.setGroupName(group);
        userDTO.setHobby(hobby);
        userDTO.setTeacher(false);
        userDTO.setToken(generatedToken);

        emailService.sendSimpleMessage(email, "Your Registration Token", "Howdy Student!\n\nHere is your Token:\n"+generatedToken);

        return this.saveUser(userDTO);
    }

    @Override
    public UserDTO registerWithToken(String token, String pass) {
        //get user by token
        UserDTO userDTO = userMapper.map(userDAO.findByToken(token));
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();

        userDTO.setPassword(passwordEncryptor.encrypt(pass));

        return this.updateUser(userDTO.getIduser(), userDTO);
    }

    @Override
    public String login(String email, String pass) {
        UserModel userModel = userDAO.findByEmail(email);
        UserDTO userDTO;

        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();

        System.out.println(passwordEncryptor.encrypt(pass));

      //  emailService.sendSimpleMessage("vicosteaua1@gmail.com", "TEST", "TEST");

        if(userModel == null) {
            return "incorrect email";
        } else{
            userDTO = userMapper.map(userModel);
            if(passwordEncryptor.encrypt(pass).equals(userDTO.getPassword())) {
                return "Login successful";
            } else {
                return "Password incorrect";
            }
        }
    }

}
