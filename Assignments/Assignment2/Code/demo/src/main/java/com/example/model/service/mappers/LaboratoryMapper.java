package com.example.model.service.mappers;

import com.example.model.dao.models.LaboratoryModel;
import com.example.model.service.models.LaboratoryDTO;

public class LaboratoryMapper {

    private AssignmentMapper assignmentMapper;

    public LaboratoryMapper(){
        this.assignmentMapper = new AssignmentMapper();
    }

    public LaboratoryDTO map(LaboratoryModel laboratoryModel) {

        return
                new LaboratoryDTO(
                        laboratoryModel.getIdlaboratory(),
                        laboratoryModel.getLabNb(),
                        laboratoryModel.getDateOfLab(),
                        laboratoryModel.getTitle(),
                        laboratoryModel.getCurricula(),
                        laboratoryModel.getLongDescription()
                        );

    }

    public LaboratoryModel map(LaboratoryDTO laboratoryDTO){
        return
                new LaboratoryModel(
                        laboratoryDTO.getIdlaboratory(),
                        laboratoryDTO.getLabNb(),
                        laboratoryDTO.getDateOfLab(),
                        laboratoryDTO.getTitle(),
                        laboratoryDTO.getCurricula(),
                        laboratoryDTO.getLongDescription()
                );
    }
}
