package com.example.model.service.impl;

import com.example.model.dao.AssignmentDAO;
import com.example.model.dao.models.AssignmentModel;
import com.example.model.service.contracts.AssignmentService;
import com.example.model.service.mappers.AssignmentMapper;
import com.example.model.service.models.AssignmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    
    private final AssignmentDAO assignmentDAO;
    private final AssignmentMapper assignmentMapper;

    @Autowired
    public AssignmentServiceImpl(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
        assignmentMapper = new AssignmentMapper();
    }

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        List<AssignmentModel> assignments = assignmentDAO.findAll();

        //lambda
        return
                assignments.stream().map(assignmentModel -> assignmentMapper.map(assignmentModel)).collect(Collectors.toList());
    }

    @Override
    public AssignmentDTO getAssignmentByID(Long idassignment) {
        return assignmentMapper.map(assignmentDAO.findById(idassignment).get());
    }

    @Override
    public AssignmentDTO saveAssignment(AssignmentDTO assignmentDTO) {
        AssignmentModel assignmentToBeSaved = assignmentMapper.map(assignmentDTO);

        assignmentDAO.save(assignmentToBeSaved);

        return assignmentDTO;
    }

    @Override
    public AssignmentDTO updateAssignment(Long idassignment, AssignmentDTO assignmentDTO) {
        AssignmentModel assignmentToBeUpdated = assignmentDAO.findById(idassignment).get();

        if(assignmentToBeUpdated != null) {
            assignmentDTO.setIdassignment(idassignment);
            assignmentDAO.save(assignmentMapper.map(assignmentDTO));

            return assignmentDTO;
        } else {
            return null;
        }

    }

    @Override
    public List<AssignmentDTO> findByIdlaboratory(Long idlaboratory) {
        List<AssignmentModel> assignments = assignmentDAO.findByLaboratoryModel_idlaboratory(idlaboratory);

        if(assignments != null){
            return assignments.stream().map(assignmentModel -> assignmentMapper.map(assignmentModel)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public void deleteAssignmentById(Long idassignment) {
        assignmentDAO.deleteById(idassignment);
    }
}
