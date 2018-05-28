package com.winterShop.controller.product;

import com.winterShop.service.contracts.product.*;
import com.winterShop.service.model.product.*;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("snowboardBoots")
public class SnowboardBootsController {

    @Autowired
    SnowboardBootsBaseService snowboardBootsService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    TargetGroupService targetGroupService;

    @Autowired
    RidingStyleService ridingStyleService;

    @Autowired
    RidingLevelService ridingLevelService;

    @GetMapping
    public String getAllSnowboardBootss(Model model){

        List<SnowboardBootsBaseDTO> snowboardBootsBases = snowboardBootsService.getAll();
        model.addAttribute("snowboardBootsBases", snowboardBootsBases);

        List<CategoryDTO> categorys = categoryService.getAll();
        model.addAttribute("categorys", categorys);

        List<BrandDTO> brands = brandService.getAll();
        model.addAttribute("brands", brands);

        List<RidingStyleDTO> ridingStyles = ridingStyleService.getAll();
        model.addAttribute("ridingStyles", ridingStyles);

        List<RidingLevelDTO> ridingLevels = ridingLevelService.getAll();
        model.addAttribute("ridingLevels", ridingLevels);

        List<TargetGroupDTO> targetGroups = targetGroupService.getAll();
        model.addAttribute("targetGroups", targetGroups);

        return "product/snowboardBoots";
    }

    @PostMapping
    public ResponseEntity<SnowboardBootsBaseDTO> createNewSnowboardBoots(@RequestBody SnowboardBootsBaseDTO snowboardBoots, Model model) {

        snowboardBoots = snowboardBootsService.save(snowboardBoots);

        return new ResponseEntity<>(snowboardBoots, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SnowboardBootsBaseDTO> editSnowboardBoots(@RequestBody SnowboardBootsBaseDTO snowboardBoots, Model model) {

        snowboardBoots = snowboardBootsService.update(snowboardBoots);

        return new ResponseEntity<>(snowboardBoots, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSnowboardBoots(@PathVariable("id") Long snowboardBootsId) {

        snowboardBootsService.delete(snowboardBootsId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "snowboardBootsBaseModel")
    public SnowboardBootsBaseDTO newSnowboardBootsBaseDTO(){
        return new SnowboardBootsBaseDTO();
    }

    @ModelAttribute(value = "categoryModel")
    public CategoryDTO newCategoryDto(){
        return new CategoryDTO();
    }

    @ModelAttribute(value = "categoryModelSnowboardBoots")
    public CategoryDTO newCategoryDtoSnowboardBoots(){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId(Long.parseLong("1"));

        return categoryDTO;
    }
}
