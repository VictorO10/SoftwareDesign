package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.snowboard.SnowboardBaseDAO;
import com.winterShop.repository.model.product.snowboard.SnowboardBase;
import com.winterShop.service.contracts.product.SnowboardBaseService;
import com.winterShop.service.model.product.snowboard.SnowboardBaseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnowboardBaseServiceImpl implements SnowboardBaseService {

    @Autowired
    SnowboardBaseDAO snowboardBaseDAO;

    private ModelMapper modelMapper;

    public SnowboardBaseServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<SnowboardBaseDTO> getAll() {
        List<SnowboardBase> snowboardBaseList = snowboardBaseDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<SnowboardBaseDTO>>() {}.getType();

        List<SnowboardBaseDTO> snowboardBaseDTOList = new ArrayList<>();

        for(SnowboardBase sb: snowboardBaseList) {
            snowboardBaseDTOList.add(modelMapper.map(sb, SnowboardBaseDTO.class));
        }

        return snowboardBaseDTOList;
    }

    @Override
    public SnowboardBaseDTO getById(Long aLong) {
        return null;
    }

    @Override
    public SnowboardBaseDTO save(SnowboardBaseDTO entity) {

        //ensure that the category is snowoboard
        entity.getCategoryDTO().setCategoryId(Long.parseLong("1"));

        SnowboardBase snowboardBase = new SnowboardBase();

        modelMapper.map(entity, snowboardBase);

        snowboardBase = snowboardBaseDAO.save(snowboardBase);

        return modelMapper.map(snowboardBase, SnowboardBaseDTO.class);
    }

    @Override
    public SnowboardBaseDTO update(SnowboardBaseDTO entity) {
        return modelMapper.map(snowboardBaseDAO.save(modelMapper.map(entity, SnowboardBase.class)), SnowboardBaseDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        snowboardBaseDAO.deleteById(aLong);

    }

}
