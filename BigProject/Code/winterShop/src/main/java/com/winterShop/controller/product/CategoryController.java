package com.winterShop.controller.product;

import com.winterShop.service.contracts.product.CategoryService;
import com.winterShop.service.model.product.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getAllCategorys(Model model){
        List<CategoryDTO> categorys = categoryService.getAll();

        model.addAttribute("categorys", categorys);

//        System.out.println(categorys);

        return "product/category";
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createNewCategory(CategoryDTO category, Model model) {

        category = categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> editCategory(CategoryDTO category, Model model) {

        category = categoryService.update(category);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long categoryId) {

        categoryService.delete(categoryId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "categoryModel")
    public CategoryDTO newCategoryDto(){
        return new CategoryDTO();
    }
}
