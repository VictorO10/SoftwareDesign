package com.winterShop.controller.product;

import com.winterShop.service.contracts.order.ShoppingCartLineService;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.product.ProductWCharsService;
import com.winterShop.service.contracts.product.SnowboardBaseService;
import com.winterShop.service.model.order.ShoppingCartLineDTO;
import com.winterShop.service.model.product.ProductWCharsDTO;
import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import com.winterShop.service.model.product.snowboard.SnowboardCharacteristicsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("snowboard/details")
public class SnowboardWCharsController {

    @Autowired
    ProductWCharsService productWCharsService;

    @Autowired
    SnowboardBaseService snowboardBaseService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ShoppingCartLineService shoppingCartLineService;

    @GetMapping
    public String getAllProductWCharss(@RequestParam(value = "productId", required = false) Long productId, Model model){

        if(productId == null) {

            List<ProductWCharsDTO> productWCharss = productWCharsService.getAll();
            model.addAttribute("productWCharss", productWCharss);

            List<SnowboardBaseDTO> snowboardBases = snowboardBaseService.getAll();
            model.addAttribute("snowboardBases", snowboardBases);

            return "product/snowboardWChars";
        } else {

            List<ProductWCharsDTO> productWCharss = productWCharsService.findByProduct_productId(productId);
            model.addAttribute("productWCharss", productWCharss);

            //get a snowboardBase which contains all the base characteristics
            SnowboardBaseDTO snowboardBaseDTO = snowboardBaseService.getById(productId);
            model.addAttribute("snowboardBase", snowboardBaseDTO);

            return "product/snowboardWCharsOneProduct"; //product w chars by product Id
        }
    }

    @PostMapping
    public ResponseEntity<ProductWCharsDTO> createNewProductWChars(@RequestBody ProductWCharsDTO productWChars, Model model) {

//        System.out.println(productWChars.getSnowboardCharacteristicsDTO().getLength());

        productWChars = productWCharsService.save(productWChars);

        return new ResponseEntity<>(productWChars, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductWCharsDTO> editProductWChars(@PathVariable("id") Long productWCharsId, ProductWCharsDTO productWChars, Model model) {

        productWChars = productWCharsService.updateImgAndStock(productWCharsId, productWChars);

        return new ResponseEntity<>(productWChars, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductWChars(@PathVariable("id") Long productWCharsId) {

        productWCharsService.delete(productWCharsId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "productWCharsModel")
    public ProductWCharsDTO newProductWCharsDto(){
        return new ProductWCharsDTO();
    }

    @ModelAttribute(value = "snowboardCharsModel")
    public SnowboardCharacteristicsDTO newSnowboardCharsDTO() {
        return new SnowboardCharacteristicsDTO();
    }

}
