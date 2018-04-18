package com.example.model.service.contracts;

import com.example.model.service.models.LaboratoryDTO;

import java.util.List;

public interface LaboratoryService {
    
    List<LaboratoryDTO> getAllLaboratories();

    LaboratoryDTO getLaboratoryByID(Long idLaboratory);

    LaboratoryDTO saveLaboratory(LaboratoryDTO LaboratoryDTO);

    LaboratoryDTO updateLaboratory(Long idLaboratory, LaboratoryDTO LaboratoryDTO);

    List<LaboratoryDTO> findByKeyword(String keyword);

    void deleteLaboratoryByLabNb(Long labNb);

    void deleteLaboratoryById(Long idLaboratory);
}
