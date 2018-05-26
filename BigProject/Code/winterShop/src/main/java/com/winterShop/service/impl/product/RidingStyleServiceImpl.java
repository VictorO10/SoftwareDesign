package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.RidingStyleDAO;
import com.winterShop.repository.model.product.RidingStyle;
import com.winterShop.service.contracts.product.RidingStyleService;
import com.winterShop.service.model.product.RidingStyleDTO;
import com.winterShop.service.model.product.RidingStyleDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RidingStyleServiceImpl implements RidingStyleService {

    @Autowired
    RidingStyleDAO ridingStyleDAO;

    private ModelMapper modelMapper;

    public RidingStyleServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public List<RidingStyleDTO> getAll() {
        List<RidingStyle> ridingStyleList = ridingStyleDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<RidingStyleDTO>>() {}.getType();

        List<RidingStyleDTO> ridingStyleDTOList = modelMapper.map(ridingStyleList, targetListType);

        return ridingStyleDTOList;
    }

    @Override
    public RidingStyleDTO getById(Long aLong) {

        RidingStyle ridingStyle = ridingStyleDAO.findById(aLong).get();
        RidingStyleDTO ridingStyleDTO = modelMapper.map(ridingStyle, RidingStyleDTO.class);
        return ridingStyleDTO;
    }

    @Override
    public RidingStyleDTO save(RidingStyleDTO entity) {

        RidingStyle ridingStyle = new RidingStyle();

        modelMapper.map(entity, ridingStyle);

        ridingStyle = ridingStyleDAO.save(ridingStyle);

        return modelMapper.map(ridingStyle, RidingStyleDTO.class);
    }

    @Override
    public RidingStyleDTO update(RidingStyleDTO entity) {
        return modelMapper.map(ridingStyleDAO.save(modelMapper.map(entity, RidingStyle.class)), RidingStyleDTO.class);
    }

    @Override
    public void delete(Long aLong) {
        ridingStyleDAO.deleteById(aLong);
    }
}
