package com.example.model.service.impl;

import com.example.model.dao.LaboratoryDAO;
import com.example.model.dao.models.LaboratoryModel;
import com.example.model.service.contracts.LaboratoryService;
import com.example.model.service.mappers.LaboratoryMapper;
import com.example.model.service.models.LaboratoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaboratoryServiceImpl implements LaboratoryService{

    private final LaboratoryDAO laboratoryDAO;
    private final LaboratoryMapper laboratoryMapper;

    @Autowired
    public LaboratoryServiceImpl(LaboratoryDAO laboratoryDAO) {
        this.laboratoryDAO = laboratoryDAO;
        this.laboratoryMapper = new LaboratoryMapper();
    }

    @Override
    public List<LaboratoryDTO> getAllLaboratories() {
        List<LaboratoryModel> laboratorys = laboratoryDAO.findAll();

        //lambda
        return
                laboratorys.stream().map(laboratoryModel -> laboratoryMapper.map(laboratoryModel)).collect(Collectors.toList());
    }

    @Override
    public LaboratoryDTO getLaboratoryByID(Long idlaboratory) {
        return laboratoryMapper.map(laboratoryDAO.findById(idlaboratory).get());
    }

    @Override
    public LaboratoryDTO saveLaboratory(LaboratoryDTO laboratoryDTO) {
        LaboratoryModel laboratoryToBeSaved = laboratoryMapper.map(laboratoryDTO);

        laboratoryDAO.save(laboratoryToBeSaved);

        return laboratoryDTO;
    }

    @Override
    public LaboratoryDTO updateLaboratory(Long idlaboratory, LaboratoryDTO laboratoryDTO) {
        LaboratoryModel laboratoryToBeUpdated = laboratoryDAO.findById(idlaboratory).get();

        if(laboratoryToBeUpdated != null) {
            laboratoryDTO.setIdlaboratory(idlaboratory);
            laboratoryDAO.save(laboratoryMapper.map(laboratoryDTO));

            return laboratoryDTO;
        } else {
            return null;
        }

    }

    @Override
    public List<LaboratoryDTO> findByKeyword(String keyword) {
        List<LaboratoryModel> labs = laboratoryDAO.findByCurriculaContainingOrLongDescriptionContaining(keyword, keyword);

        //lambda
            return labs.stream().map(laboratoryModel -> laboratoryMapper.map(laboratoryModel)).collect(Collectors.toList());
    }

    @Override
    public void deleteLaboratoryByLabNb(Long labNb) {
        LaboratoryModel laboratoryModel = laboratoryDAO.findByLabNb(labNb);

        this.deleteLaboratoryById(laboratoryModel.getIdlaboratory());
    }

    @Override
    public void deleteLaboratoryById(Long idlaboratory) {
        laboratoryDAO.deleteById(idlaboratory);
    }
}
