package com.winterShop.service.impl.order;

import com.winterShop.repository.contracts.order.OrderDetailsDAO;
import com.winterShop.repository.model.order.OrderDetails;
import com.winterShop.repository.model.order.OrderItem;
import com.winterShop.service.contracts.order.OrderDetailsService;
import com.winterShop.service.contracts.order.ShoppingCartLineService;
import com.winterShop.service.contracts.user.LoggedInService;
import com.winterShop.service.model.order.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsDAO orderDetailsDAO;

    @Autowired
    LoggedInService loggedInService;

    @Autowired
    ShoppingCartLineService shoppingCartLineService;

    private ModelMapper modelMapper;

    public OrderDetailsServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @Override
    public List<OrderDetailsDTO> getAll() {
        List<OrderDetails> orderDetailsList = orderDetailsDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<OrderDetailsDTO>>() {
        }.getType();

        List<OrderDetailsDTO> orderDetailsDTOList = modelMapper.map(orderDetailsList, targetListType);

        return orderDetailsDTOList;
    }

    @Override
    public OrderDetailsDTO getById(Long aLong) {

        OrderDetails orderDetails = orderDetailsDAO.findById(aLong).get();
        OrderDetailsDTO orderDetailsDTO = modelMapper.map(orderDetails, OrderDetailsDTO.class);
        return orderDetailsDTO;
    }

    @Override
    public OrderDetailsDTO save(OrderDetailsDTO entity) {

        OrderDetails orderDetails = new OrderDetails();

        modelMapper.map(entity, orderDetails);

        orderDetails = orderDetailsDAO.save(orderDetails);


        return modelMapper.map(orderDetails, OrderDetailsDTO.class);
    }

    @Override
    public OrderDetailsDTO update(OrderDetailsDTO entity) {
        OrderDetails orderDetails = new OrderDetails();

        modelMapper.map(entity, orderDetails);

        orderDetails = orderDetailsDAO.save(orderDetails);

        return modelMapper.map(orderDetails, OrderDetailsDTO.class);
    }

    @Override
    public void delete(Long aLong) {
        orderDetailsDAO.deleteById(aLong);
    }


    //creates a order for the current logged in user
    private OrderDetailsDTO newEmptyOrderDetailsDTO(){

        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setUserDTO(loggedInService.getLoggedInUserDTO());


//        System.out.println("LOGGED IN ID: " + orderDetailsDTO.getUserDTO().getUserId());

        return this.save(orderDetailsDTO);
    }

    @Override
    public OrderDetailsDTO saveWithShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        OrderDetailsDTO orderDetailsDTO = newEmptyOrderDetailsDTO();

        Set<OrderItemDTO> orderItemDTOSet = new HashSet<>();

        //carefully map each line from the shopping cart to a line in the Order
        for(ShoppingCartLineDTO scl: shoppingCartDTO.getShoppingCartLineDTOSet()) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();

            orderItemDTO.setProductWCharsDTO(scl.getProductWCharsDTO());
            orderItemDTO.setAmmount(scl.getAmmount());
            orderItemDTO.setOrderDetailsDTO(orderDetailsDTO);

            orderItemDTOSet.add(orderItemDTO);


            //delete every line from the shopping cart, since the transaction has been accepted
            shoppingCartLineService.delete(scl.getShoppingCartLineId());
        }
        orderDetailsDTO.setOrderItemDTOSet(orderItemDTOSet);

        orderDetailsDTO.setOrderStatusDTO(OrderStatusDTO.WAITING_FOR_PROCESSING);



        return this.update(orderDetailsDTO);
    }

    @Override
    public Set<OrderDetailsDTO> getByLoggedInUser() {
        Set<OrderDetails> orderDetailsSet = orderDetailsDAO.findAllByUser_email(loggedInService.getLoggedInEmail());

        java.lang.reflect.Type targetSetType = new TypeToken<Set<OrderDetailsDTO>>() {
        }.getType();

        Set<OrderDetailsDTO> orderDetailsDTOSet = modelMapper.map(orderDetailsSet, targetSetType);

        return orderDetailsDTOSet;
    }
}