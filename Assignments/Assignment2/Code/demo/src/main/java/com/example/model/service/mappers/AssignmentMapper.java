package com.example.model.service.mappers;

import com.example.model.dao.models.AssignmentModel;
import com.example.model.dao.models.LaboratoryModel;
import com.example.model.service.models.AssignmentDTO;
import com.example.model.service.models.LaboratoryDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AssignmentMapper {


    public AssignmentDTO map(AssignmentModel assignmentModel) {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        LaboratoryMapper laboratoryMapper = new LaboratoryMapper();

        assignmentDTO.setIdassignment(assignmentModel.getIdassignment());
        assignmentDTO.setName(assignmentModel.getName());
        assignmentDTO.setDeadline(assignmentModel.getDeadline());
        assignmentDTO.setLongDescription(assignmentModel.getLongDescription());
        assignmentDTO.setIdlaboratory(assignmentModel.getLaboratoryModel().getIdlaboratory());
 //       assignmentDTO.setLaboratoryDTO(laboratoryMapper.map(assignmentModel.getLaboratoryModel()));

        return assignmentDTO;
    }

    public AssignmentModel map(AssignmentDTO assignmentDTO) {
        AssignmentModel assignmentModel = new AssignmentModel();
        LaboratoryMapper laboratoryMapper = new LaboratoryMapper();

        assignmentModel.setIdassignment(assignmentDTO.getIdassignment());
        assignmentModel.setName(assignmentDTO.getName());
        assignmentModel.setDeadline(assignmentDTO.getDeadline());
        assignmentModel.setLongDescription(assignmentDTO.getLongDescription());

        //create Laboratory with id idlaboratory from assignment DTO
        LaboratoryModel laboratoryModel = new LaboratoryModel();
        laboratoryModel.setIdlaboratory(assignmentDTO.getIdlaboratory());

        assignmentModel.setLaboratoryModel(laboratoryModel);

 //       assignmentModel.setLaboratoryModel(laboratoryMapper.map(assignmentDTO.getLaboratoryDTO()));

        return assignmentModel;
    }

    public Set<AssignmentDTO> mapSetModel(Set<AssignmentModel> assignmentModels) {
        Set<AssignmentDTO> assignmentDTOs = new HashSet<>();

        assignmentDTOs =
                    assignmentModels.stream().map(assignmentModel -> this.map(assignmentModel)).collect(Collectors.toSet());

        return assignmentDTOs;
    }

    public Set<AssignmentModel> mapSetDTO(Set<AssignmentDTO> assignmentDTOs) {
        Set<AssignmentModel> assignmentModels = new HashSet<>();

        assignmentModels =
                assignmentDTOs.stream().map(assignmentDTO -> this.map(assignmentDTO)).collect(Collectors.toSet());

        return assignmentModels;
    }
}
