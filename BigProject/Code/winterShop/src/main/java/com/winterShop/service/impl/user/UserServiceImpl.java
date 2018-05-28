package com.winterShop.service.impl.user;

import com.winterShop.repository.contracts.order.ShoppingCartDAO;
import com.winterShop.repository.contracts.user.UserDAO;
import com.winterShop.repository.model.order.ShoppingCart;
import com.winterShop.repository.model.user.User;
import com.winterShop.repository.model.user.UserRole;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.user.UserService;
import com.winterShop.service.model.user.UserDTO;
import com.winterShop.service.model.user.UserRoleDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper;

    public UserServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> userList = userDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<UserDTO>>() {}.getType();

        List<UserDTO> userDTOList = modelMapper.map(userList, targetListType);

        return userDTOList;
    }

    @Override
    public UserDTO getById(Long aLong) {
        User user = userDAO.findById(aLong).get();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO save(UserDTO entity) {

        User user = new User();

        modelMapper.map(entity, user);

        user = userDAO.save(user);

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO entity) {
        return modelMapper.map(userDAO.save(modelMapper.map(entity, User.class)), UserDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        userDAO.deleteById(aLong);

    }

    @Override
    public UserDTO getByEmail(String email) {
        User user = userDAO.findByEmail(email);
  //      System.out.println("UserService: " + user);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
 //       System.out.println("UserService DTO: " + userDTO);
        return userDTO;
    }

    @Override
    public UserDTO register(String email, String password) {

        User user = new User();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        //set the roles for the user
        Set<UserRole> roles = new HashSet<UserRole>();
        roles.add(UserRole.CLIENT);
        user.setRoles(roles);

        user = userDAO.save(user);

        //create an empty shopping cart for the user
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDAO.save(shoppingCart);

        return modelMapper.map(user, UserDTO.class);
    }
}
