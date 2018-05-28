package com.winterShop.controller.order;

import com.winterShop.repository.model.order.ShoppingCart;
import com.winterShop.service.contracts.order.ShoppingCartLineService;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.model.order.ShoppingCartDTO;
import com.winterShop.service.model.order.ShoppingCartLineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("order/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartLineService shoppingCartLineService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping
    public String getCart(Model model){

        ShoppingCartDTO shoppingCart = shoppingCartService.getByLoggedInEmail();

        model.addAttribute("shoppingCart", shoppingCart);

        return "order/shoppingCart";
    }

    @PostMapping
    public ResponseEntity<ShoppingCartLineDTO> addObjectToCart(@RequestParam(value="productWCharsId") Long productWCharsId){

        ShoppingCartLineDTO shoppingCartLineDTO = shoppingCartLineService.save(productWCharsId);

        return new ResponseEntity<>(shoppingCartLineDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long shoppingCartLineId) {

        shoppingCartLineService.delete(shoppingCartLineId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
