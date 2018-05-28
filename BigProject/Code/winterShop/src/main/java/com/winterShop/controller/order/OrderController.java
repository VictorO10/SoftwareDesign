package com.winterShop.controller.order;

import com.winterShop.repository.model.order.OrderDetails;
import com.winterShop.service.contracts.order.OrderDetailsService;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.product.ProductWCharsService;
import com.winterShop.service.model.order.OrderDetailsDTO;
import com.winterShop.service.model.order.OrderStatusDTO;
import com.winterShop.service.model.order.ShoppingCartDTO;
import com.winterShop.service.model.order.ShoppingCartLineDTO;
import com.winterShop.service.model.product.ProductWCharsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderDetailsService orderService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ProductWCharsService productWCharsService;

    @GetMapping("/admin")
    public String getAllOrders(Model model){
        List<OrderDetailsDTO> orders = orderService.getAll();

        model.addAttribute("orders", orders);

        return "order/orderAdmin";
    }

    @GetMapping
    public String getAllOrdersByLoggedInUser(Model model){

        Set<OrderDetailsDTO> orders = orderService.getByLoggedInUser();

 //       System.out.println(orders.isEmpty());

        model.addAttribute("orders", orders);

        return "order/orderOne";
    }

    @PostMapping
    public ResponseEntity<OrderDetailsDTO> createNewOrder(Model model) {

        ShoppingCartDTO shoppingCart = shoppingCartService.getByLoggedInEmail();

        //see if the stock of each product is fine, if yes, reduce by 1
        for(ShoppingCartLineDTO scl: shoppingCart.getShoppingCartLineDTOSet()) {
            ProductWCharsDTO productWCharsDTO = scl.getProductWCharsDTO();

            if(productWCharsDTO.getStock() <= 0) {
                return new ResponseEntity<>(new OrderDetailsDTO(), HttpStatus.PRECONDITION_FAILED);
            } else {
                productWCharsDTO.decrementStock();
            }
        }
        //if they all passed(every product has at least 1 in stock), persist the changes in the database
        for(ShoppingCartLineDTO scl: shoppingCart.getShoppingCartLineDTOSet()) {
            ProductWCharsDTO productWCharsDTO = scl.getProductWCharsDTO();

            productWCharsService.updateImgAndStock(productWCharsDTO.getProductWCharsId(), productWCharsDTO);
        }

        OrderDetailsDTO order = orderService.saveWithShoppingCart(shoppingCart);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDetailsDTO> editOrder(OrderDetailsDTO order, Model model) {

        order = orderService.update(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("admin/{id}")
    public ResponseEntity<OrderDetailsDTO> updateStatus(@PathVariable("id") Long orderDetailsId, String status, Model model) {

        OrderDetailsDTO orderDetailsDTO = orderService.getById(orderDetailsId);

        System.out.println(status);

        orderDetailsDTO.setOrderStatusDTO(OrderStatusDTO.valueOf(status));

        orderDetailsDTO = orderService.update(orderDetailsDTO);

        return new ResponseEntity<>(orderDetailsDTO, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long orderId) {

        orderService.delete(orderId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "orderModel")
    public OrderDetailsDTO newOrderDetailsDTO(){
        return new OrderDetailsDTO();
    }


}
