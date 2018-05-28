package com.winterShop.controller.product;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.winterShop.service.contracts.order.ShoppingCartLineService;
import com.winterShop.service.contracts.order.ShoppingCartService;
import com.winterShop.service.contracts.product.ColorService;
import com.winterShop.service.contracts.product.ProductWCharsService;
import com.winterShop.service.contracts.product.ShoeSizeService;
import com.winterShop.service.contracts.product.SnowboardBootsBaseService;
import com.winterShop.service.model.order.ShoppingCartLineDTO;
import com.winterShop.service.model.product.ColorDTO;
import com.winterShop.service.model.product.ProductWCharsDTO;
import com.winterShop.service.model.product.ShoeSizeDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsCharacteristicsDTO;
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
@RequestMapping("snowboardBoots/details")
public class SnowboardBootsWCharsController {

    @Autowired
    ProductWCharsService productWCharsService;

    @Autowired
    SnowboardBootsBaseService snowboardBootsBaseService;

    @Autowired
    ColorService colorService;

    @Autowired
    ShoeSizeService shoeSizeService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ShoppingCartLineService shoppingCartLineService;

    @GetMapping
    public String getAllProductWCharss(@RequestParam(value = "productId", required = false) Long productId, Model model){

        if(productId == null) {

            List<ProductWCharsDTO> productWCharss = productWCharsService.getAll("snowboardBoots");
            model.addAttribute("productWCharss", productWCharss);

            System.out.println(productWCharss.size());

            List<ColorDTO> colors = colorService.getAll();
            model.addAttribute("colors", colors);

            List<ShoeSizeDTO> shoeSizes = shoeSizeService.getAll();
            model.addAttribute("shoeSizes", shoeSizes);

            List<SnowboardBootsBaseDTO> snowboardBootsBases = snowboardBootsBaseService.getAll();
            model.addAttribute("snowboardBootsBases", snowboardBootsBases);

            return "product/snowboardBootsWChars";
        } else {

            List<ProductWCharsDTO> productWCharss = productWCharsService.findByProduct_productId(productId);
            model.addAttribute("productWCharss", productWCharss);

            //get a snowboardBootsBase which contains all the base characteristics
            SnowboardBootsBaseDTO snowboardBootsBaseDTO = snowboardBootsBaseService.getById(productId);
            model.addAttribute("snowboardBootsBase", snowboardBootsBaseDTO);

            return "product/snowboardBootsWCharsOneProduct"; //product w chars by product Id
        }
    }

    @PostMapping
    public ResponseEntity<ProductWCharsDTO> createNewProductWChars(@RequestBody ProductWCharsDTO productWChars, Model model) {

//        System.out.println(productWChars.getSnowboardBootsCharacteristicsDTO().getLength());

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

    @ModelAttribute(value = "snowboardBootsCharsModel")
    public SnowboardBootsCharacteristicsDTO newSnowboardBootsCharsDTO() {
        return new SnowboardBootsCharacteristicsDTO();
    }

}
