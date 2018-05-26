package com.winterShop.controller.product;

import com.winterShop.service.contracts.product.BrandService;
import com.winterShop.service.contracts.product.CategoryService;
import com.winterShop.service.contracts.product.ProductService;
import com.winterShop.service.contracts.product.TargetGroupService;
import com.winterShop.service.model.product.BrandDTO;
import com.winterShop.service.model.product.CategoryDTO;
import com.winterShop.service.model.product.ProductDTO;
import com.winterShop.service.model.product.TargetGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    TargetGroupService targetGroupService;

    @GetMapping
    public String getAllProducts(Model model){

        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);


        List<CategoryDTO> categorys = categoryService.getAll();
        model.addAttribute("categorys", categorys);


        List<BrandDTO> brands = brandService.getAll();
        model.addAttribute("brands", brands);

        List<TargetGroupDTO> targetGroups = targetGroupService.getAll();
        model.addAttribute("targetGroups", targetGroups);

        return "product/product";
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createNewProduct(@RequestBody ProductDTO product, Model model) {

        product = productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO product, Model model) {

        product = productService.update(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {

        productService.delete(productId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ModelAttribute(value = "productModel")
    public ProductDTO newProductDto(){
        return new ProductDTO();
    }

    @ModelAttribute(value = "categoryModel")
    public CategoryDTO newCategoryDto(){
        return new CategoryDTO();
    }
}
