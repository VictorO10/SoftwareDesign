package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.RidingLevelDAO;
import com.winterShop.repository.model.product.RidingLevel;
import com.winterShop.service.contracts.product.RidingLevelService;
import com.winterShop.service.model.product.RidingLevelDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RidingLevelServiceImpl implements RidingLevelService {

    @Autowired
    RidingLevelDAO ridingLevelDAO;

    private ModelMapper modelMapper;

    public RidingLevelServiceImpl() {
        modelMapper = new ModelMapper();
    }

    @Override
    public List<RidingLevelDTO> getAll() {
        List<RidingLevel> ridingLevelList = ridingLevelDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<RidingLevelDTO>>() {}.getType();

        List<RidingLevelDTO> ridingLevelDTOList = modelMapper.map(ridingLevelList, targetListType);

        return ridingLevelDTOList;
    }

    @Override
    public RidingLevelDTO getById(Long aLong) {

        RidingLevel ridingLevel = ridingLevelDAO.findById(aLong).get();
        RidingLevelDTO ridingLevelDTO = modelMapper.map(ridingLevel, RidingLevelDTO.class);
        return ridingLevelDTO;
    }

    @Override
    public RidingLevelDTO save(RidingLevelDTO entity) {

        RidingLevel ridingLevel = new RidingLevel();

        modelMapper.map(entity, ridingLevel);

        ridingLevel = ridingLevelDAO.save(ridingLevel);

        return modelMapper.map(ridingLevel, RidingLevelDTO.class);
    }

    @Override
    public RidingLevelDTO update(RidingLevelDTO entity) {
        return modelMapper.map(ridingLevelDAO.save(modelMapper.map(entity, RidingLevel.class)), RidingLevelDTO.class);
    }

    @Override
    public void delete(Long aLong) {
        ridingLevelDAO.deleteById(aLong);
    }
}
