package com.winterShop.service.impl.product;

import com.winterShop.repository.model.product.Brand;
import com.winterShop.service.contracts.product.BrandService;
import com.winterShop.service.model.product.BrandDTO;
import com.winterShop.repository.contracts.product.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDAO brandDAO;

    private ModelMapper modelMapper;

    public BrandServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<BrandDTO> getAll() {
        List<Brand> brandList = brandDAO.findAll();

//        System.out.println(brandList);

        java.lang.reflect.Type targetListType = new TypeToken<List<BrandDTO>>() {}.getType();

        List<BrandDTO> brandDTOList = modelMapper.map(brandList, targetListType);

//        System.out.println(brandDTOList);

        return brandDTOList;
    }

    @Override
    public BrandDTO getById(Long aLong) {
        return null;
    }

    @Override
    public BrandDTO save(BrandDTO entity) {

        Brand brand = new Brand();

        modelMapper.map(entity, brand);

        brand = brandDAO.save(brand);

        return modelMapper.map(brand, BrandDTO.class);
    }

    @Override
    public BrandDTO update(BrandDTO entity) {
        return modelMapper.map(brandDAO.save(modelMapper.map(entity, Brand.class)), BrandDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        brandDAO.deleteById(aLong);

    }
}
