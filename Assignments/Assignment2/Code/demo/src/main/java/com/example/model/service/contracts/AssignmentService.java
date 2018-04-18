package com.example.model.service.contracts;

import com.example.model.service.models.AssignmentDTO;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDTO> getAllAssignments();

    AssignmentDTO getAssignmentByID(Long idAssignment);

    AssignmentDTO saveAssignment(AssignmentDTO AssignmentDTO);

    AssignmentDTO updateAssignment(Long idAssignment, AssignmentDTO AssignmentDTO);

    List<AssignmentDTO> findByIdlaboratory(Long idlaboratory);

    void deleteAssignmentById(Long idAssignment);
    
}
