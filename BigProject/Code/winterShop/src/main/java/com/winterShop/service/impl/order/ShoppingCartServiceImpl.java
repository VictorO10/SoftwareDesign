package com.winterShop.service.impl.order;

import com.winterShop.repository.contracts.order.ShoppingCartDAO;
import com.winterShop.repository.model.order.ShoppingCart;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.user.LoggedInService;
import com.winterShop.service.model.order.ShoppingCartDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    
    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Autowired
    LoggedInService loggedInService;

    private ModelMapper modelMapper;

    public ShoppingCartServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ShoppingCartDTO> getAll() {
        List<ShoppingCart> shoppingCartList = shoppingCartDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<ShoppingCartDTO>>() {}.getType();

        List<ShoppingCartDTO> shoppingCartDTOList = modelMapper.map(shoppingCartList, targetListType);

        return shoppingCartDTOList;
    }

    @Override
    public ShoppingCartDTO getById(Long aLong) {

        ShoppingCart shoppingCart = shoppingCartDAO.findById(aLong).get();
        ShoppingCartDTO shoppingCartDTO = modelMapper.map(shoppingCart, ShoppingCartDTO.class);
        return shoppingCartDTO;
    }

    @Override
    public ShoppingCartDTO save(ShoppingCartDTO entity) {

        ShoppingCart shoppingCart = new ShoppingCart();

        modelMapper.map(entity, shoppingCart);

        shoppingCart = shoppingCartDAO.save(shoppingCart);

        return modelMapper.map(shoppingCart, ShoppingCartDTO.class);
    }

    @Override
    public ShoppingCartDTO update(ShoppingCartDTO entity) {
        return modelMapper.map(shoppingCartDAO.save(modelMapper.map(entity, ShoppingCart.class)), ShoppingCartDTO.class);
    }

    @Override
    public void delete(Long aLong) {
        shoppingCartDAO.deleteById(aLong);
    }

    @Override
    public Long findShoppingCartIdByUserEmail(String email) {
        return shoppingCartDAO.findShoppingCart_shoppingCartIdByUser_email(email).getShoppingCartId();
    }

    @Override
    public ShoppingCartDTO findShoppingCartByUserEmail(String email) {
        ShoppingCart shoppingCart = shoppingCartDAO.findShoppingCart_shoppingCartIdByUser_email(email);

        ShoppingCartDTO shoppingCartDTO = modelMapper.map(shoppingCart, ShoppingCartDTO.class);

        return shoppingCartDTO;
    }

    @Override
    public ShoppingCartDTO getByLoggedInEmail(){
        return findShoppingCartByUserEmail(loggedInService.getLoggedInEmail());
    }
}
