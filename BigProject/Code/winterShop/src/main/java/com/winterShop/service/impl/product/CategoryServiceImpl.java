package com.winterShop.service.impl.product;

import com.winterShop.repository.model.product.Category;
import com.winterShop.service.contracts.product.CategoryService;
import com.winterShop.service.model.product.CategoryDTO;
import com.winterShop.repository.contracts.product.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    private ModelMapper modelMapper;

    public CategoryServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categoryList = categoryDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<CategoryDTO>>() {}.getType();

        List<CategoryDTO> categoryDTOList = modelMapper.map(categoryList, targetListType);

        return categoryDTOList;
    }

    @Override
    public CategoryDTO getById(Long aLong) {

        Category category = categoryDAO.findById(aLong).get();
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public CategoryDTO save(CategoryDTO entity) {

        Category category = new Category();

        modelMapper.map(entity, category);

        category = categoryDAO.save(category);

        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO entity) {
        return modelMapper.map(categoryDAO.save(modelMapper.map(entity, Category.class)), CategoryDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        categoryDAO.deleteById(aLong);

    }
}
