package com.winterShop.controller.product;

import com.winterShop.service.contracts.product.BrandService;
import com.winterShop.service.model.product.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public String getAllBrands(Model model){
        List<BrandDTO> brands = brandService.getAll();

        model.addAttribute("brands", brands);

        System.out.println(brands);

        return "product/brand";
    }

    @PostMapping
    public ResponseEntity<BrandDTO> createNewBrand(BrandDTO brand, Model model) {

        brand = brandService.save(brand);

        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BrandDTO> editBrand(BrandDTO brand, Model model) {

        brand = brandService.update(brand);

        return new ResponseEntity<>(brand, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long brandId) {

        brandService.delete(brandId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "brandModel")
    public BrandDTO newBrandDto(){
        return new BrandDTO();
    }


}
