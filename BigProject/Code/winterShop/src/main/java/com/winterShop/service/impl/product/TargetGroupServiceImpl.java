package com.winterShop.service.impl.product;

import com.winterShop.repository.contracts.product.TargetGroupDAO;
import com.winterShop.repository.model.product.TargetGroup;
import com.winterShop.service.contracts.product.TargetGroupService;
import com.winterShop.service.model.product.TargetGroupDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetGroupServiceImpl implements TargetGroupService {

    @Autowired
    TargetGroupDAO targetGroupDAO;

    private ModelMapper modelMapper;

    public TargetGroupServiceImpl() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Override
    public List<TargetGroupDTO> getAll() {
        List<TargetGroup> targetGroupList = targetGroupDAO.findAll();

        java.lang.reflect.Type targetListType = new TypeToken<List<TargetGroupDTO>>() {}.getType();

        List<TargetGroupDTO> targetGroupDTOList = modelMapper.map(targetGroupList, targetListType);

        return targetGroupDTOList;
    }

    @Override
    public TargetGroupDTO getById(Long aLong) {

        TargetGroup targetGroup = targetGroupDAO.findById(aLong).get();
        TargetGroupDTO targetGroupDTO = modelMapper.map(targetGroup, TargetGroupDTO.class);
//        System.out.println("SERVICE " + targetGroupDTO);
        return targetGroupDTO;
    }

    @Override
    public TargetGroupDTO save(TargetGroupDTO entity) {

        TargetGroup targetGroup = new TargetGroup();

        modelMapper.map(entity, targetGroup);

        targetGroup = targetGroupDAO.save(targetGroup);

        return modelMapper.map(targetGroup, TargetGroupDTO.class);
    }

    @Override
    public TargetGroupDTO update(TargetGroupDTO entity) {
        return modelMapper.map(targetGroupDAO.save(modelMapper.map(entity, TargetGroup.class)), TargetGroupDTO.class);
    }

    @Override
    public void delete(Long aLong) {

        targetGroupDAO.deleteById(aLong);

    }

}
