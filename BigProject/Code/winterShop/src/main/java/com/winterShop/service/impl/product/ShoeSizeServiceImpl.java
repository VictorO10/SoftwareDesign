package com.winterShop.service.impl.product;

import com.winterShop.repository.model.product.ShoeSize;
import com.winterShop.service.contracts.product.ShoeSizeService;
import com.winterShop.service.model.product.ShoeSizeDTO;
import com.winterShop.repository.contracts.product.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoeSizeServiceImpl implements ShoeSizeService {

    @Autowired
    ShoeSizeDAO shoeSizeDAO;

    private ModelMapper modelMapper;

    public ShoeSizeServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ShoeSizeDTO> getAll() {
        List<ShoeSize> shoeSizeList = shoeSizeDAO.findAll();

//        System.out.println(shoeSizeList);

        java.lang.reflect.Type targetListType = new TypeToken<List<ShoeSizeDTO>>() {}.getType();

        List<ShoeSizeDTO> shoeSizeDTOList = modelMapper.map(shoeSizeList, targetListType);

//        System.out.println(shoeSizeDTOList);

        return shoeSizeDTOList;
    }

    @Override
    public ShoeSizeDTO getById(Long aLong) {
        ShoeSize shoeSize = shoeSizeDAO.findById(aLong).get();
        ShoeSizeDTO shoeSizeDTO = modelMapper.map(shoeSize, ShoeSizeDTO.class);
        return shoeSizeDTO;
    }

    @Override
    public ShoeSizeDTO save(ShoeSizeDTO entity) {

        ShoeSize shoeSize = new ShoeSize();

        modelMapper.map(entity, shoeSize);

        shoeSize = shoeSizeDAO.save(shoeSize);

        return modelMapper.map(shoeSize, ShoeSizeDTO.class);
    }

    @Override
    public ShoeSizeDTO update(ShoeSizeDTO entity) {
        return modelMapper.map(shoeSizeDAO.save(modelMapper.map(entity, ShoeSize.class)), ShoeSizeDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        shoeSizeDAO.deleteById(aLong);

    }
}
