package com.winterShop.service.impl.order;

import com.winterShop.repository.contracts.order.ShoppingCartLineDAO;
import com.winterShop.repository.model.order.ShoppingCartLine;
import com.winterShop.service.contracts.order.ShoppingCartLineService;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.user.LoggedInService;
import com.winterShop.service.model.order.ShoppingCartDTO;
import com.winterShop.service.model.order.ShoppingCartLineDTO;
import com.winterShop.service.model.product.ProductWCharsDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartLineServiceImpl implements ShoppingCartLineService {

    @Autowired
    ShoppingCartLineDAO shoppingCartLineDAO;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    LoggedInService loggedInService;

    private ModelMapper modelMapper;

    public ShoppingCartLineServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ShoppingCartLineDTO> getAll() {
        List<ShoppingCartLine> shoppingCartLineList = shoppingCartLineDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<ShoppingCartLineDTO>>() {}.getType();

        List<ShoppingCartLineDTO> shoppingCartLineDTOList = modelMapper.map(shoppingCartLineList, targetListType);

        return shoppingCartLineDTOList;
    }

    @Override
    public ShoppingCartLineDTO getById(Long aLong) {

        ShoppingCartLine shoppingCartLine = shoppingCartLineDAO.findById(aLong).get();
        ShoppingCartLineDTO shoppingCartLineDTO = modelMapper.map(shoppingCartLine, ShoppingCartLineDTO.class);
        return shoppingCartLineDTO;
    }

    @Override
    public ShoppingCartLineDTO save(ShoppingCartLineDTO entity) {

        ShoppingCartLine shoppingCartLine = new ShoppingCartLine();

        modelMapper.map(entity, shoppingCartLine);

        shoppingCartLine = shoppingCartLineDAO.save(shoppingCartLine);

        return modelMapper.map(shoppingCartLine, ShoppingCartLineDTO.class);
    }

    @Override
    public ShoppingCartLineDTO update(ShoppingCartLineDTO entity) {
        return modelMapper.map(shoppingCartLineDAO.save(modelMapper.map(entity, ShoppingCartLine.class)), ShoppingCartLineDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        shoppingCartLineDAO.deleteById(aLong);

    }

    /*creates new shoppingCartLine where the productWCharsId is set and the shoppingCartId is set.
    It then calls the normal save()
    */
    @Override
    public ShoppingCartLineDTO save(Long productWCharsId) {


        ShoppingCartLineDTO shoppingCartLineDTO = new ShoppingCartLineDTO();
        shoppingCartLineDTO.setProductWCharsDTO(new ProductWCharsDTO());
        shoppingCartLineDTO.getProductWCharsDTO().setProductWCharsId(productWCharsId);


        //get


        shoppingCartLineDTO.setShoppingCartDTO(new ShoppingCartDTO());
        shoppingCartLineDTO.getShoppingCartDTO().setShoppingCartId(shoppingCartService.findShoppingCartIdByUserEmail(loggedInService.getLoggedInEmail()));

        System.out.println("CART ID: " + shoppingCartService.findShoppingCartIdByUserEmail(loggedInService.getLoggedInEmail()));

        return save(shoppingCartLineDTO);
    }
}
