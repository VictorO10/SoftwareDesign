package com.winterShop.service.impl.product;

import com.winterShop.repository.model.product.Color;
import com.winterShop.service.contracts.product.ColorService;
import com.winterShop.service.model.product.ColorDTO;
import com.winterShop.repository.contracts.product.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorDAO colorDAO;

    private ModelMapper modelMapper;

    public ColorServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<ColorDTO> getAll() {
        List<Color> colorList = colorDAO.findAll();


        java.lang.reflect.Type targetListType = new TypeToken<List<ColorDTO>>() {}.getType();

        List<ColorDTO> colorDTOList = modelMapper.map(colorList, targetListType);

        return colorDTOList;
    }

    @Override
    public ColorDTO getById(Long aLong) {
        Color color = colorDAO.findById(aLong).get();
        ColorDTO colorDTO = modelMapper.map(color, ColorDTO.class);
        return colorDTO;
    }

    @Override
    public ColorDTO save(ColorDTO entity) {

        Color color = new Color();

        modelMapper.map(entity, color);

        color = colorDAO.save(color);

        return modelMapper.map(color, ColorDTO.class);
    }

    @Override
    public ColorDTO update(ColorDTO entity) {
        return modelMapper.map(colorDAO.save(modelMapper.map(entity, Color.class)), ColorDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        colorDAO.deleteById(aLong);

    }
}
