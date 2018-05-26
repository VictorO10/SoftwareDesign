package com.winterShop.controller.product;

import com.winterShop.service.contracts.product.*;
import com.winterShop.service.model.product.BrandDTO;
import com.winterShop.service.model.product.CategoryDTO;
import com.winterShop.service.model.product.RidingStyleDTO;
import com.winterShop.service.model.product.TargetGroupDTO;
import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("snowboard")
public class SnowboardController {

    @Autowired
    SnowboardBaseService snowboardService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    TargetGroupService targetGroupService;

    @Autowired
    RidingStyleService ridingStyleService;

    @GetMapping
    public String getAllSnowboards(Model model){

        List<SnowboardBaseDTO> snowboardBases = snowboardService.getAll();
        model.addAttribute("snowboardBases", snowboardBases);

        List<CategoryDTO> categorys = categoryService.getAll();
        model.addAttribute("categorys", categorys);

        List<BrandDTO> brands = brandService.getAll();
        model.addAttribute("brands", brands);

        List<RidingStyleDTO> ridingStyles = ridingStyleService.getAll();
        model.addAttribute("ridingStyles", ridingStyles);

        List<TargetGroupDTO> targetGroups = targetGroupService.getAll();
        model.addAttribute("targetGroups", targetGroups);

        return "product/snowboard";
    }

    @PostMapping
    public ResponseEntity<SnowboardBaseDTO> createNewSnowboard(@RequestBody SnowboardBaseDTO snowboard, Model model) {

        snowboard = snowboardService.save(snowboard);

        return new ResponseEntity<>(snowboard, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SnowboardBaseDTO> editSnowboard(@RequestBody SnowboardBaseDTO snowboard, Model model) {

        snowboard = snowboardService.update(snowboard);

        return new ResponseEntity<>(snowboard, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSnowboard(@PathVariable("id") Long snowboardId) {

        snowboardService.delete(snowboardId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "snowboardBaseModel")
    public SnowboardBaseDTO newSnowboardBaseDTO(){
        return new SnowboardBaseDTO();
    }

    @ModelAttribute(value = "categoryModel")
    public CategoryDTO newCategoryDto(){
        return new CategoryDTO();
    }

    @ModelAttribute(value = "categoryModelSnowboard")
    public CategoryDTO newCategoryDtoSnowboard(){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId(Long.parseLong("1"));

        return categoryDTO;
    }
}
