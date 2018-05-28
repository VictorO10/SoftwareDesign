package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.snowboardBoots.SnowboardBootsBaseDAO;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;
import com.winterShop.service.contracts.product.SnowboardBootsBaseService;
import com.winterShop.service.model.product.snowboardBoots.SnowboardBootsBaseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnowboardBootsBaseServiceImpl implements SnowboardBootsBaseService {

    @Autowired
    SnowboardBootsBaseDAO snowboardBootsBaseDAO;

    private ModelMapper modelMapper;

    public SnowboardBootsBaseServiceImpl() {

        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<SnowboardBootsBaseDTO> getAll() {
        List<SnowboardBootsBase> snowboardBootsBaseList = snowboardBootsBaseDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<SnowboardBootsBaseDTO>>() {}.getType();

        List<SnowboardBootsBaseDTO> snowboardBootsBaseDTOList = new ArrayList<>();

        for(SnowboardBootsBase sb: snowboardBootsBaseList) {
            snowboardBootsBaseDTOList.add(modelMapper.map(sb, SnowboardBootsBaseDTO.class));
        }

        return snowboardBootsBaseDTOList;
    }

    @Override
    public SnowboardBootsBaseDTO getById(Long aLong) {
        SnowboardBootsBase snowboardBootsBase;
        SnowboardBootsBaseDTO snowboardBootsBaseDTO;

        if(snowboardBootsBaseDAO.findById(aLong).isPresent()){
            snowboardBootsBase = snowboardBootsBaseDAO.findById(aLong).get();
            snowboardBootsBaseDTO = modelMapper.map(snowboardBootsBase, SnowboardBootsBaseDTO.class);
        } else
        {
            snowboardBootsBase = null;
            snowboardBootsBaseDTO = null;
        }


        return snowboardBootsBaseDTO;
    }

    @Override
    public SnowboardBootsBaseDTO save(SnowboardBootsBaseDTO entity) {

        //ensure that the category is snowoboard
        entity.getCategoryDTO().setCategoryId(Long.parseLong("1"));

        SnowboardBootsBase snowboardBootsBase = new SnowboardBootsBase();

        modelMapper.map(entity, snowboardBootsBase);

        snowboardBootsBase = snowboardBootsBaseDAO.save(snowboardBootsBase);

        return modelMapper.map(snowboardBootsBase, SnowboardBootsBaseDTO.class);
    }

    @Override
    public SnowboardBootsBaseDTO update(SnowboardBootsBaseDTO entity) {
        return modelMapper.map(snowboardBootsBaseDAO.save(modelMapper.map(entity, SnowboardBootsBase.class)), SnowboardBootsBaseDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        snowboardBootsBaseDAO.deleteById(aLong);
    }
}
