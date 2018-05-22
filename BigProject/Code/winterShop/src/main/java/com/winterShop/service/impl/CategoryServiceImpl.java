package com.winterShop.service.impl;

import com.winterShop.service.contracts.product.CategoryService;
import com.winterShop.service.model.product.CategoryDTO;
import com.winterShop.repository.contracts.product.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> getAll() {
        return null;
    }

    @Override
    public CategoryDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CategoryDTO save(CategoryDTO entity) {
        return null;
    }

    @Override
    public CategoryDTO update(CategoryDTO entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
